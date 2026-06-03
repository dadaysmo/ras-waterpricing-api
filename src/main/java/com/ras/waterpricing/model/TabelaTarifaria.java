package com.ras.waterpricing.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "tabelas_tarifarias")
public class TabelaTarifaria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataVigencia;

    @OneToMany(mappedBy = "tabelaTarifaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoriaTarifa> categorias = new ArrayList<>();

    public TabelaTarifaria(){
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public LocalDate getDataVigencia(){
        return dataVigencia;
    }
    public void setDataVigencia(LocalDate dataVigencia){
        this.dataVigencia = dataVigencia;
    }

    public List<CategoriaTarifa> getCategorias(){
        return categorias;
    }
    public void setCategorias(List<CategoriaTarifa> categorias){
        this.categorias = categorias;
    }
}