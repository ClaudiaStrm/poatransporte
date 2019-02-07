package com.example.poatransporte.service;

import com.example.poatransporte.entity.Onibus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OnibusService {

    private String idResource;

    public Page<Onibus> findAll(Pageable pageable) {

        return null; //onibusRepository().findAll(pageable);
    }
}
