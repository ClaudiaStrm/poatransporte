package com.example.poatransporte.repository;

import com.example.poatransporte.entity.Itinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {

    List<Itinerario> findByIdLinha(@Param("idLinha") Long idLinha);

}
