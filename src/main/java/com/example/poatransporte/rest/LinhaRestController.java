package com.example.poatransporte.rest;

import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.service.LinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/linha")
public class LinhaRestController {

    @Autowired
    private LinhaService linhaService;

    @GetMapping("/todas")
    public ResponseEntity<List<Linha>> listarLinhas() throws IOException {
        return ResponseEntity.ok(linhaService.buscarLinhas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Linha> buscarPorId(@PathVariable Long id) throws IOException {
        return linhaService.buscarPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/integracao")
    public ResponseEntity<String> integrarBancoComAPI() throws IOException {
        return ResponseEntity.ok(linhaService.integrarBancoComAPI());
    }
}
