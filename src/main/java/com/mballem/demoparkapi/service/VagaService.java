package com.mballem.demoparkapi.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.demoparkapi.entity.Vaga;
import com.mballem.demoparkapi.exception.CodigoUniqueViolationException;
import com.mballem.demoparkapi.exception.EntityNotFoundException;
import com.mballem.demoparkapi.repository.VagaRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class VagaService {
    
    private final VagaRepository vagaRepository;

    @Transactional
    public Vaga salvar(Vaga vaga){
        try{
            return vagaRepository.save(vaga);
        } catch (DataIntegrityViolationException ex) {
            throw new CodigoUniqueViolationException(String.format("Vaga com código '%s' já cadastrada", vaga.getCodigo()));
        }
    }

    @Transactional
    public Vaga buscarPorCodigo(String codigo){
        return vagaRepository.findByCodigo(codigo).orElseThrow(
            () -> new EntityNotFoundException(String.format("Vaga com código '%s' não foi encontrado", codigo))
        );
    }
}
