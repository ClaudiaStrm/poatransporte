package com.example.poatransporte.entity;

import com.example.poatransporte.entity.Localizacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Onibus {

    @Id
    @Column(name = "ID", nullable = false)
    protected Long id;

    @Length(max = 200, min = 5)
    @Column(name = "NOME", nullable = false)
    protected String nome;

    @Length(max = 20, min = 7)
    @Column(name = "CODIGO", nullable = false)
    protected String codigo;

}
