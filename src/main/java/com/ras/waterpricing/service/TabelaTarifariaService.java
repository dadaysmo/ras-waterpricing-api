package com.ras.waterpricing.service;

import com.ras.waterpricing.model.TabelaTarifaria;
import com.ras.waterpricing.repository.TabelaTarifariaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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
}