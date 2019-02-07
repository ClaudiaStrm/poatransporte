package com.example.poatransporte.service;

import com.example.poatransporte.entity.Onibus;
import com.example.poatransporte.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OnibusService {

    @Autowired
    private OnibusRepository onibusRepository;

    public Page<Onibus> findAll(Pageable pageable) {

        return onibusRepository.findAll(pageable);
    }
}
