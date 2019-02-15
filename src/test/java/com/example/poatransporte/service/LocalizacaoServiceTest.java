package com.example.poatransporte.service;

import com.example.poatransporte.dto.LinhaDTO;
import com.example.poatransporte.dto.LocalizacaoDTO;
import com.example.poatransporte.entity.Localizacao;
import com.example.poatransporte.repository.LocalizacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalizacaoServiceTest {

    @InjectMocks
    private LocalizacaoService localizacaoService;

    @Mock
    private LocalizacaoRepository localizacaoRepository;

    @InjectMocks
    private ItinerarioService itinerarioService;

    @SuppressWarnings("unchecked")
//    @Before
//    public void setUp() {


    @Test
    public void testSalvarLocalizacaoEItinerario() {

        LinhaDTO linha = new LinhaDTO();

        LocalizacaoDTO localizacao = LocalizacaoDTO.builder()
                .idLinha(1l)
                .lat("3454565443")
                .lng("4343343343")
                .build();

        Map<Integer, LocalizacaoDTO> mapLocalizacao = new HashMap<>();
        Map.Entry<String,LocalizacaoDTO> entryLocalizacao =
                new AbstractMap.SimpleEntry<>("1", localizacao);




    }

    @Test
    public void testSalvarLocalizacao() {

        Localizacao localizacao = Localizacao.builder()
                .id(1l)
                .latitude("3454565443")
                .longitude("4343343343")
                .build();

        when(localizacaoRepository.save(localizacao)).thenReturn(localizacao);
        Assertions.assertEquals(localizacaoService.salvarLocalizacao(localizacao), localizacao);

        verify(localizacaoRepository).save(localizacao);
    }
}