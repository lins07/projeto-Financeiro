package com.financias.demo.repository;

import com.financias.demo.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    
}
