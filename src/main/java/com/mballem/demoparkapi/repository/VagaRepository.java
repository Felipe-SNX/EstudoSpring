package com.mballem.demoparkapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mballem.demoparkapi.entity.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long>{
    
    Optional<Vaga> findByCodigo(String codigo);
}
