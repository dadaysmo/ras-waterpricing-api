package com.ras.waterpricing.controller;

import com.ras.waterpricing.dto.CalculoRequest;
import com.ras.waterpricing.dto.CalculoResponse;
import com.ras.waterpricing.service.TabelaTarifariaService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculos")
public class CalculoController {

    private final TabelaTarifariaService service;

    public CalculoController(TabelaTarifariaService service) {
        this.service = service;
    }

    @PostMapping
    public CalculoResponse calcularFatura(@RequestBody CalculoRequest request) {
        BigDecimal total = service.calcularFatura(
            request.getTabelaId(), 
            request.getCategoria(), 
            request.getConsumo()
        );
        return new CalculoResponse(total);
    }
}