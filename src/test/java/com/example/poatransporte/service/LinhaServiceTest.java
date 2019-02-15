package com.example.poatransporte.service;


import com.example.poatransporte.dto.LinhaDTO;
import com.example.poatransporte.entity.Itinerario;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.repository.ItinerarioRepository;
import com.example.poatransporte.repository.LinhaRepository;
import org.assertj.core.util.Lists;
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
public class LinhaServiceTest {

    @Mock
    private LinhaRepository linhaRepository;

    @InjectMocks
    private LinhaService linhaService;

    @Mock
    private ItinerarioRepository itinerarioRepository;

    @Test
    public void testBuscarLinhas() {
        Linha linha = Linha.builder()
                .id(544l)
                .codigo("4567-9")
                .nome("Linha")
                .build();

        when(linhaRepository.findAll()).thenReturn(Lists.newArrayList(linha));
        Assertions.assertEquals(linhaService.buscarLinhas(), Lists.newArrayList(linha));

        verify(linhaRepository).findAll();
    }

    @Test
    public void testBuscarPorId() {
        Linha linha = Linha.builder()
                .id(544l)
                .codigo("4567-9")
                .nome("Linha")
                .build();

        LinhaDTO dto = linha.mapToDTO();
        List<Itinerario> listaItinerario = new ArrayList<>();

        dto.setListaItinerario(listaItinerario);

        when(linhaRepository.findById(linha.getId())).thenReturn(Optional.of(linha));
        Assertions.assertEquals(linhaService.buscarPorId(linha.getId()), dto);

        verify(linhaRepository).findById(linha.getId());
    }

    @Test
    public void testBuscarPorNome() {
        Linha linha = Linha.builder()
                .id(544l)
                .codigo("4567-9")
                .nome("Linha")
                .build();

        when(linhaRepository.findByNomeIgnoreCase(linha.getNome())).thenReturn(Lists.newArrayList(linha));
        Assertions.assertEquals(linhaService.buscarPorNome(linha.getNome()), Lists.newArrayList(linha));

        verify(linhaRepository).findByNomeIgnoreCase(linha.getNome());
    }
}