package com.ras.waterpricing.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "faixas_consumo")
public class FaixaConsumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer inicio;
    private Integer fim;

    private BigDecimal valorUnitario;

    @ManyToOne
    @JoinColumn(name = "categoria_tarifa_id")
    @JsonIgnore
    private CategoriaTarifa categoriaTarifa;

    public FaixaConsumo(){
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Integer getInicio(){
        return inicio;
    }
    public void setInicio(Integer inicio){
        this.inicio = inicio;
    }

    public Integer getFim() {
        return fim;
    }
    public void setFim(Integer fim) {
        this.fim = fim;
    }

    public BigDecimal getValorUnitario(){
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario){
        this.valorUnitario = valorUnitario;
    }

    public CategoriaTarifa getCategoriaTarifa(){
        return categoriaTarifa;
    }
    public void setCategoriaTarifa(CategoriaTarifa categoriaTarifa){
        this.categoriaTarifa = categoriaTarifa;
    }
}