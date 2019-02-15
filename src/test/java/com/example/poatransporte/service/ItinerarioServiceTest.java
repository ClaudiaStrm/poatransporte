package com.example.poatransporte.service;

import com.example.poatransporte.entity.Itinerario;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.entity.Localizacao;
import com.example.poatransporte.repository.ItinerarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ItinerarioServiceTest {

    @InjectMocks
    private ItinerarioService itinerarioService;

    @Mock
    private ItinerarioRepository itinerarioRepository;

    @Test
    public void testSalvarItinerario() {

        Linha linha = Linha.builder()
                .id(544l)
                .codigo("4567-9")
                .nome("Linha")
                .build();

        Localizacao localizacao = Localizacao.builder()
                .id(1l)
                .latitude("3454565443")
                .longitude("4343343343")
                .build();

        Itinerario itinerario = Itinerario.builder()
                .idLinha(linha.getId())
                .idLocalizacao(localizacao.getId())
                .trajeto(23)
                .build();

        when(itinerarioRepository.save(itinerario)).thenReturn(itinerario);
        Assertions.assertEquals(itinerarioService.salvarItinerario(linha, localizacao, "23"), itinerario);

        verify(itinerarioRepository).save(itinerario);
    }
}