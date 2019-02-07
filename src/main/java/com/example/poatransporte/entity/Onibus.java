package com.example.poatransporte.entity;

import com.example.poatransporte.entity.Localizacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Onibus {
    protected Long idLinha;
    protected String codigo;
    protected String nome;
    protected List<Localizacao> itinerario;
}
