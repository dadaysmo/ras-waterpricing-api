package com.ras.waterpricing.dto;

import com.ras.waterpricing.model.Categoria;

public class CalculoRequest {
    private Long tabelaId;
    private Categoria categoria;
    private Integer consumo;

    public Long getTabelaId(){
        return tabelaId;
    }
    public void setTabelaId(Long tabelaId){
        this.tabelaId = tabelaId;
    }

    public Categoria getCategoria(){
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getConsumo(){
        return consumo;
    }
    public void setConsumo(Integer consumo){
        this.consumo = consumo;
    }
}
