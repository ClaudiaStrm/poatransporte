package com.example.poatransporte.service;

import com.example.poatransporte.entity.Cliente;
import com.example.poatransporte.entity.ClienteLinha;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.repository.ClienteLinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteLinhaService {
    @Autowired
    ClienteLinhaRepository clienteLinhaRepository;

    public ClienteLinha salvar(Cliente cliente, Linha linha) {
        return clienteLinhaRepository.save(ClienteLinha.builder()
                                            .idCliente(cliente.getId())
                                            .idLinha(linha.getId())
                                            .build());
    }
}
