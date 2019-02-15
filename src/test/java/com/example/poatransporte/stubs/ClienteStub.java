package com.example.poatransporte.stubs;

import com.example.poatransporte.dto.ClienteDTO;
import com.example.poatransporte.entity.Cliente;

public class ClienteStub {

    public static ClienteDTO clienteDto() {
        return ClienteDTO.builder()
                .id(1l)
                .cpf("28382823238")
                .nome("Cliente Jr.")
                .linhas(LinhaStub.listaLinhas())
                .build();
    }

    public static Cliente cliente() {
        return Cliente.builder()
                .id(1l)
                .cpf("28382823238")
                .nome("Cliente Jr.")
                .build();
    }
}
