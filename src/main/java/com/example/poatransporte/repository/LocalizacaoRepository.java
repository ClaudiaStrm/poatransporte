package com.example.poatransporte.repository;

import com.example.poatransporte.entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

    Localizacao findByLatitudeAndLongitude(
            @Param("latitude") String latitude,
            @Param("longitude") String longitude);

}
