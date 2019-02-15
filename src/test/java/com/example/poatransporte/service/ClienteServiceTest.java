package com.example.poatransporte.service;

import com.example.poatransporte.dto.ClienteDTO;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.repository.ClienteLinhaRepository;
import com.example.poatransporte.repository.ClienteRepository;
import com.example.poatransporte.stubs.ClienteStub;
import com.example.poatransporte.stubs.LinhaStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @Mock
    private ClienteLinhaService clienteLinhaService;

    @Mock
    private ClienteLinhaRepository clienteLinhaRepository;

    @Mock
    private LinhaService linhaService;

    @Test
    public void testSalvar() {
        when(clienteRepository.save(Mockito.any())).thenReturn(ClienteStub.clienteDto().mapToCliente());

        ClienteDTO cliente =  ClienteStub.clienteDto();
        List<Linha> linha = new ArrayList();
        cliente.setLinhas(linha);

        Assertions.assertEquals(clienteService.salvar(cliente), cliente);

        verify(clienteRepository).save(ClienteStub.cliente());
    }

    @Test
    public void testBuscarCliente() {

        when(clienteService.findById(Mockito.any())).thenReturn(Optional.of(ClienteStub.cliente()));
        Assertions.assertEquals(
                clienteService.findById(Mockito.any()), Optional.of(ClienteStub.cliente()));
        verify(clienteRepository).findById(Mockito.any());
    }

    @Test
    public void testSalvarLinhasCliente() {
        when(clienteLinhaService.salvar(Mockito.any(), Mockito.any())).thenReturn(LinhaStub.clienteLinha());
        when(linhaService.findById(Mockito.any())).thenReturn(Optional.of(LinhaStub.linha()));

        Assertions.assertEquals(clienteLinhaService.salvar(
                ClienteStub.cliente(), LinhaStub.linha()), LinhaStub.clienteLinha());
        Assertions.assertEquals(linhaService.findById(LinhaStub.linha().getId()), Optional.of(LinhaStub.linha()));

        verify(clienteLinhaService).salvar(Mockito.any(), Mockito.any());
        verify(linhaService).findById(Mockito.any());

    }

    @Test
    public void testExibirClienteComLinha() {
        when(clienteLinhaRepository.findByIdCliente(Mockito.any())).thenReturn(LinhaStub.listaClienteLinha());
        when(linhaService.findById(Mockito.any())).thenReturn(Optional.of(LinhaStub.linha()));

        Assertions.assertEquals(clienteLinhaRepository.findByIdCliente(1L), LinhaStub.listaClienteLinha());
        Assertions.assertEquals(linhaService.findById(LinhaStub.linha().getId()), Optional.of(LinhaStub.linha()));

        verify(linhaService).findById(Mockito.any());
        verify(clienteLinhaRepository).findByIdCliente(Mockito.any());
    }

    @Test
    public void testDeleteCliente() {
        clienteService.save(ClienteStub.cliente());
        clienteService.delete(ClienteStub.cliente().getId());

        verify(clienteRepository).deleteById(ClienteStub.cliente().getId());
    }

    @Test
    public void testFindById() {

        when(clienteRepository.findById(ClienteStub.cliente().getId()))
                .thenReturn(Optional.of(ClienteStub.cliente()));
        Assertions.assertEquals(clienteService.findById(
                ClienteStub.cliente().getId()), Optional.of(ClienteStub.cliente()));

        verify(clienteRepository).findById(ClienteStub.cliente().getId());
    }
}