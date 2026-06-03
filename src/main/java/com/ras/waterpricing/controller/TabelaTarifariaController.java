package com.ras.waterpricing.controller;

import com.ras.waterpricing.model.TabelaTarifaria;
import com.ras.waterpricing.service.TabelaTarifariaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tabelas-tarifarias")
public class TabelaTarifariaController {

    private final TabelaTarifariaService service;

    public TabelaTarifariaController(TabelaTarifariaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TabelaTarifaria criar(@RequestBody TabelaTarifaria tabela) {
        return service.salvar(tabela);
    }

    @GetMapping
    public List<TabelaTarifaria> listar() {
        return service.listarTodas();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}