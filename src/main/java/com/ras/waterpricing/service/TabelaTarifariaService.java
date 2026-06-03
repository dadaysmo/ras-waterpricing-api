package com.ras.waterpricing.service;

import com.ras.waterpricing.model.TabelaTarifaria;
import com.ras.waterpricing.repository.TabelaTarifariaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ras.waterpricing.model.Categoria;
import com.ras.waterpricing.model.CategoriaTarifa;
import com.ras.waterpricing.model.FaixaConsumo;
import java.math.BigDecimal;
import java.util.Comparator;

@Service
public class TabelaTarifariaService {
    
    private final TabelaTarifariaRepository repository;

    public TabelaTarifariaService(TabelaTarifariaRepository repository){
        this.repository = repository;
    }

    public TabelaTarifaria salvar(TabelaTarifaria tabela){

        if (tabela.getCategorias() != null) {
            tabela.getCategorias().forEach(categoria -> {
                categoria.setTabelaTarifaria(tabela);
                
                if (categoria.getFaixas() != null) {
                    categoria.getFaixas().forEach(faixa -> faixa.setCategoriaTarifa(categoria));
                }
            });
        }
        return repository.save(tabela);
    }

    public List<TabelaTarifaria> listarTodas() {
        return repository.findAll();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public BigDecimal calcularFatura(Long tabelaId, Categoria categoria, Integer consumoTotal) {

        TabelaTarifaria tabela = repository.findById(tabelaId)
                .orElseThrow(() -> new RuntimeException("Tabela não encontrada"));

        CategoriaTarifa categoriaTarifa = tabela.getCategorias().stream()
                .filter(c -> c.getCategoria() == categoria)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada nesta tabela"));

        List<FaixaConsumo> faixas = categoriaTarifa.getFaixas();
        faixas.sort(Comparator.comparing(FaixaConsumo::getInicio));

        BigDecimal valorTotal = BigDecimal.ZERO;
        int consumoRestante = consumoTotal;

        for (FaixaConsumo faixa : faixas) {
            if (consumoRestante <= 0) break;

            int consumoAnterior = faixa.getInicio() > 0 ? faixa.getInicio() - 1 : 0;
            int capacidadeDaFaixa = faixa.getFim() - consumoAnterior;
            
            int consumoNestaFaixa = Math.min(consumoRestante, capacidadeDaFaixa);
            
            BigDecimal custoDaFaixa = faixa.getValorUnitario().multiply(new BigDecimal(consumoNestaFaixa));
            valorTotal = valorTotal.add(custoDaFaixa);
            
            consumoRestante -= consumoNestaFaixa;
        }

        return valorTotal;
    }
}