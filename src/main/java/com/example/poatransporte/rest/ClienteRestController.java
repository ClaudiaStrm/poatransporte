package com.example.poatransporte.rest;

import com.example.poatransporte.dto.ClienteDTO;
import com.example.poatransporte.entity.Cliente;
import com.example.poatransporte.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ClienteDTO get(@PathVariable Long id) {
        return clienteService.buscarCliente(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> put(@PathVariable Long id, @RequestBody ClienteDTO input) {
        return ResponseEntity.ok(clienteService.salvar(input));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> post(@RequestBody ClienteDTO input) {
        return ResponseEntity.ok(clienteService.salvar(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
