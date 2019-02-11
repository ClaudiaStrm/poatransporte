package com.example.poatransporte.rest;

import com.example.poatransporte.dto.OnibusDTO;
import com.example.poatransporte.entity.Onibus;
import com.example.poatransporte.service.OnibusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/linha")
public class OnibusRestController {

    @Autowired
    private OnibusService onibusService;

    @GetMapping("/todas")
    public ResponseEntity< Page<Onibus> > listarOnibus(Pageable pageable) throws IOException {
        return ResponseEntity.ok( onibusService.buscarLinhas(pageable) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnibusDTO> buscarPorId(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok( onibusService.buscarPorId(id) );
    }
}
