package com.example.poatransporte.entity;

import com.example.poatransporte.classes.ClienteLinhaId;
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
@IdClass(ClienteLinhaId.class)
@Table(name = "ClienteLinha")
public class ClienteLinha implements Serializable {

    @Id
    @Column(name = "idCliente", nullable = false)
    protected Long idCliente;

    @Id
    @Column(name = "idLinha", nullable = false)
    protected Long idLinha;

}
