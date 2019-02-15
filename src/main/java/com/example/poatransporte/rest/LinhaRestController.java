package com.example.poatransporte.rest;

import com.example.poatransporte.dto.LinhaDTO;
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

    @GetMapping("/id/{id}")
    public ResponseEntity<LinhaDTO> buscarPorId(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(linhaService.buscarPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Linha>> buscarPorNome(@PathVariable String nome) throws IOException {
        return ResponseEntity.ok(linhaService.buscarPorNome(nome));
    }

    @GetMapping("/integracao")
    public ResponseEntity.BodyBuilder integrarBancoComAPI() throws IOException {
        return ResponseEntity.status(200);
    }
}
