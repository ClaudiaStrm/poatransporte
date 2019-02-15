package com.example.poatransporte.repository;

import com.example.poatransporte.entity.Linha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LinhaRepository extends JpaRepository<Linha, Long> {

    List<Linha> findByNomeIgnoreCase(@Param("nome") String nome);
}
