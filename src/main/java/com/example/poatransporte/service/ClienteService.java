package com.example.poatransporte.service;

import com.example.poatransporte.dto.ClienteDTO;
import com.example.poatransporte.entity.Cliente;
import com.example.poatransporte.entity.ClienteLinha;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.repository.ClienteLinhaRepository;
import com.example.poatransporte.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService extends AbstractCrudService <Cliente> {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteLinhaService clienteLinhaService;

    @Autowired
    LinhaService linhaService;

    @Autowired
    ClienteLinhaRepository clienteLinhaRepository;

    @Override
    protected JpaRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }

    @Transactional
    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente  = this.save(dto.mapToCliente());
        this.salvarLinhasCliente(cliente, dto.getLinhas());
        return exibirClienteComLinhas(cliente);
    }

    public ClienteDTO buscarCliente(Long id) {
        Cliente cliente = this.findById(id).get();
        return exibirClienteComLinhas(cliente);
    }

    public void salvarLinhasCliente(Cliente cliente, List<Linha> linhas) {
        if (ObjectUtils.isEmpty(linhas))  return;
        linhas.forEach(linha -> {
            clienteLinhaService.salvar(cliente, linhaService.findById(linha.getId()).get());
        });
    }

    public ClienteDTO exibirClienteComLinhas(Cliente cliente) {
        List<Linha> linhasCliente = new ArrayList<>();
        for (ClienteLinha clienteLinha : clienteLinhaRepository.findByIdCliente(cliente.getId())) {
            linhasCliente.add(linhaService.findById(clienteLinha.getIdLinha()).get());
        }

        return ClienteDTO.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .id(cliente.getId())
                .linhas(linhasCliente)
                .build();
    }
}
