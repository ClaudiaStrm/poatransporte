package com.example.poatransporte.repository;

import com.example.poatransporte.entity.ClienteLinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteLinhaRepository extends JpaRepository<ClienteLinha, Long> {

    public List<ClienteLinha> findByIdCliente(Long id);
}
