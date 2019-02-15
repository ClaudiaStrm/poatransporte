package com.example.poatransporte.service;

import com.example.poatransporte.dto.ClienteDTO;
import com.example.poatransporte.entity.Cliente;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

   // @Test
    public void testSalvar() {
        List<Linha> linhas = new ArrayList<>();
        ClienteDTO cliente = ClienteDTO.builder()
                .id(1l)
                .cpf("28382823238")
                .nome("Cliente Jr.")
                .linhas(linhas)
                .build();

        when(clienteRepository.save(cliente.mapToCliente())).thenReturn(cliente.mapToCliente());
        Assertions.assertEquals(clienteService.salvar(cliente), cliente);

        verify(clienteRepository).save(cliente.mapToCliente());
    }

    @Test
    public void testSalvarLinhasCliente() {


    }

    @Test
    public void testDeleteCliente() {
        Cliente cliente = Cliente.builder()
                .id(1l)
                .cpf("28382823238")
                .nome("Cliente Jr.")
                .build();

        clienteService.save(cliente);
        clienteService.delete(cliente.getId());

        verify(clienteRepository).deleteById(cliente.getId());
    }

    @Test
    public void testFindById() {
        Cliente cliente = Cliente.builder()
                .id(1l)
                .cpf("28382823238")
                .nome("Cliente Jr.")
                .build();

        when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
        Assertions.assertEquals(clienteService.findById(cliente.getId()), Optional.of(cliente));

        verify(clienteRepository).findById(cliente.getId());
    }


}