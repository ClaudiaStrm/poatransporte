package com.example.poatransporte.service;

import com.example.poatransporte.entity.Itinerario;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.entity.Localizacao;
import com.example.poatransporte.repository.ItinerarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItinerarioService extends AbstractCrudService <Itinerario>{

    @Autowired
    ItinerarioRepository itinerarioRepository;

    @Override
    protected JpaRepository<Itinerario, Long> getRepository() {
        return itinerarioRepository;
    }

    @Transactional(readOnly = false)
    public Itinerario salvar(Linha linha, Localizacao localizacao, String trajeto) {
        return itinerarioRepository.save(
                Itinerario.builder()
                .idLinha(linha.getId())
                .idLocalizacao(localizacao.getId())
                .trajeto(Integer.parseInt(trajeto))
                .build());
    }
}
