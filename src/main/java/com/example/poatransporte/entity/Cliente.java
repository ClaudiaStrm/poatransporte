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
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Cliente_SEQ")
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "cpf")
    protected String cpf;

    //protected List<Linha> linhasCliente;




}
