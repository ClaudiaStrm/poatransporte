package com.example.poatransporte.service;

import com.example.poatransporte.entity.Cliente;
import com.example.poatransporte.entity.ClienteLinha;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.repository.ClienteLinhaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteLinhaServiceTest {

    @InjectMocks
    private ClienteLinhaService clienteLinhaService;

    @Mock
    private ClienteLinhaRepository clienteLinhaRepository;


    @Test
    public void salvar() {
        Linha linha = Linha.builder()
                .id(544l)
                .codigo("4567-9")
                .nome("Linha")
                .build();

        Cliente cliente = Cliente.builder()
                .id(1l)
                .cpf("28382823238")
                .nome("Cliente Jr.")
                .build();

        ClienteLinha clienteLinha = ClienteLinha.builder()
                .idLinha(linha.getId())
                .idCliente(cliente.getId())
                .build();

        when(clienteLinhaRepository.save(clienteLinha)).thenReturn(clienteLinha);
        Assertions.assertEquals(clienteLinhaService.salvar(cliente, linha), clienteLinha);

        verify(clienteLinhaRepository).save(clienteLinha);
    }
}