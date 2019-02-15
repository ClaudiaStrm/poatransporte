package com.example.poatransporte.service;

import com.example.poatransporte.dto.LinhaDTO;
import com.example.poatransporte.dto.LocalizacaoDTO;
import com.example.poatransporte.entity.Localizacao;
import com.example.poatransporte.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class LocalizacaoService extends AbstractCrudService<Localizacao> {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private ItinerarioService itinerarioService;

    @Transactional
    public void salvarLocalizacaoEItinerario(LinhaDTO linhaDTO) {
        Map<String, LocalizacaoDTO> itinerarioLinha = linhaDTO.getItinerario();
        itinerarioLinha.entrySet().forEach(localizacaoDTO -> {
            Localizacao localizacao = this.salvarLocalizacao(
                    localizacaoDTO.getValue().mapToLocalizacao());
            itinerarioService.salvarItinerario(linhaDTO.mapToLinha(), localizacao, localizacaoDTO.getKey());
        });
    }

    @Transactional
    public Localizacao salvarLocalizacao(Localizacao localizacao) {
        return this.save(localizacao);
    }

    @Override
    protected JpaRepository<Localizacao, Long> getRepository() {
        return localizacaoRepository;
    }
}
