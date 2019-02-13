package com.example.poatransporte.service;


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
    public void testFindAll() {
        Linha linha = Linha.builder()
                .id(544l)
                .codigo("4567-9")
                .nome("Linha")
                .build();

        when(linhaRepository.findAll()).thenReturn(Lists.newArrayList(linha));
        Assertions.assertEquals(linhaService.buscarLinhas(), Lists.newArrayList(linha));

        verify(linhaRepository).findAll();
    }
}