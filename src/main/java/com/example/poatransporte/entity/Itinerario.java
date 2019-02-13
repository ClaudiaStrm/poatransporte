package com.example.poatransporte.entity;

import com.example.poatransporte.classes.ItinerarioId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ItinerarioId.class)
@Table(name = "Itinerario")
public class Itinerario implements Serializable {

    @Id
    @Column(name = "idLinha", nullable = false)
    protected Long idLinha;

    @Id
    @Column(name = "idLocalizacao", nullable = false)
    protected Long idLocalizacao;

    @Column(name = "trajeto")
    protected int trajeto;
}
