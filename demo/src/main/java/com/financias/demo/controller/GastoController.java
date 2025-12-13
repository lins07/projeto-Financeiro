package com.financias.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financias.demo.model.Gasto;
import com.financias.demo.service.GastoService;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoService Service;

    public GastoController(GastoService Service) {
        this.Service = Service;
    }

    @PostMapping
    public Gasto criar(@RequestBody Gasto gasto) {
        return Service.salvar(gasto);
    }

    @GetMapping
    public List<Gasto> listar() {
        return Service.listarTodos();
    }
    
}
