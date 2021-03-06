package com.example.poatransporte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Localizacao")
public class Localizacao {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Localizacao_SEQ")
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "latitude")
    protected String latitude;

    @Column(name = "longitude")
    protected String longitude;
}
