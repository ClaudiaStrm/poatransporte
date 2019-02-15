package com.example.poatransporte.stubs;

import com.example.poatransporte.entity.ClienteLinha;
import com.example.poatransporte.entity.Linha;
import org.assertj.core.util.Lists;

import java.util.List;

public class LinhaStub {

    public static List<Linha> listaLinhas() {
        return Lists.newArrayList(Linha.builder()
                                          .id(1l)
                                          .nome("Linha")
                                          .build());
    }

    public static List<ClienteLinha> listaClienteLinha() {
        return Lists.newArrayList(ClienteLinha.builder()
                                          .idLinha(1l)
                                          .idCliente(1l)
                                          .build());
    }

    public static ClienteLinha clienteLinha() {
        return ClienteLinha.builder()
                .idLinha(1l)
                .idCliente(1l)
                .build();
    }

    public static Linha linha() {
        return Linha.builder()
                .id(1l)
                .nome("Linha")
                .build();
    }
}
