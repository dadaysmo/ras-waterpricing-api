package com.ras.waterpricing.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categorias_tarifa")
public class CategoriaTarifa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "tabela_tarifaria_id")
    @JsonIgnore
    private TabelaTarifaria tabelaTarifaria;

    @OneToMany(mappedBy = "categoriaTarifa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FaixaConsumo> faixas = new ArrayList<>();

    public CategoriaTarifa(){
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Categoria getCategoria(){
        return categoria;
    }
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public TabelaTarifaria getTabelaTarifaria(){
        return tabelaTarifaria;
    }
    public void setTabelaTarifaria(TabelaTarifaria tabelaTarifaria){
        this.tabelaTarifaria = tabelaTarifaria;
    }

    public List<FaixaConsumo> getFaixas(){
        return faixas;
    }
    public void setFaixas(List<FaixaConsumo> faixas){
        this.faixas = faixas;
    }
}