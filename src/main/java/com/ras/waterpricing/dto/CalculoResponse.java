package com.ras.waterpricing.dto;

import java.math.BigDecimal;

public class CalculoResponse {
    private BigDecimal valorTotal;

    public CalculoResponse(BigDecimal valorTotal){
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal(){
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal){
        this.valorTotal = valorTotal;
    }
}
