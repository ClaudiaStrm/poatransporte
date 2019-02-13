package com.example.poatransporte.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Linha")
public class Linha {

    @Id
    @Column(name = "id", nullable = false)
    protected Long id;

    @Length(max = 60, min = 2)
    @Column(name = "nome", nullable = false)
    protected String nome;

    @Length(max = 8, min = 3)
    @Column(name = "codigo", nullable = false)
    protected String codigo;

}
