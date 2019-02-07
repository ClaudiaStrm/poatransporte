package com.example.poatransporte.rest;

import com.example.poatransporte.entity.Onibus;
import com.example.poatransporte.service.OnibusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OnibusRestController {

    @Autowired
    private OnibusService onibusService;

    @GetMapping("/linhas")
    public ResponseEntity<Page<Onibus>> list(Pageable pageable) {
        return ResponseEntity.ok(onibusService.findAll(pageable));
    }
}
