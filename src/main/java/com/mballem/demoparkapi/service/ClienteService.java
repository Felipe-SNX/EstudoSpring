package com.mballem.demoparkapi.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.demoparkapi.entity.Cliente;
import com.mballem.demoparkapi.exception.CpfUniqueViolationException;
import com.mballem.demoparkapi.exception.EntityNotFoundException;
import com.mballem.demoparkapi.repository.ClienteRepository;
import com.mballem.demoparkapi.repository.projection.ClienteProjection;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException ex) {
            throw new CpfUniqueViolationException(String.format("CPF '%s' nao pode ser cadastrado, ja existe no sistema", cliente.getCpf()));
        }
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(String.format("Cliente id=%s nao encontrado no sistema", id))
        );
    }

    @Transactional(readOnly = true)
    public Page<ClienteProjection> buscarTodos(Pageable pageable){
        return clienteRepository.findAllPageable(pageable);
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorUsuarioId(Long id){
        return clienteRepository.findByUsuarioId(id);
    }
}
