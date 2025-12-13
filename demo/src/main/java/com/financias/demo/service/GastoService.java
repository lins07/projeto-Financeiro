package com.financias.demo.service;

import com.financias.demo.model.Gasto;
import com.financias.demo.repository.GastoRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GastoService {

    private final GastoRepository Repository;

    public GastoService(GastoRepository repository) {
        Repository = repository;
    }

    public Gasto salvar(Gasto gasto) {
        return Repository.save(gasto);
    }

    public List<Gasto> listarTodos() {
        return Repository.findAll();
    }
    
}
