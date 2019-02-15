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
@Table(name = "Cliente")
@SequenceGenerator(name="CLIENTE_SEQ", sequenceName="cliente_seq", allocationSize=1, initialValue = 1)
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="cliente_seq")
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "cpf")
    protected String cpf;
}
