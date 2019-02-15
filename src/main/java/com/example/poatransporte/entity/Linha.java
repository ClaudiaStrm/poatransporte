package com.example.poatransporte.entity;

import com.example.poatransporte.dto.LinhaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


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


    public LinhaDTO mapToDTO() {
        return LinhaDTO
                .builder()
                .id(this.id)
                .codigo(this.codigo)
                .nome(this.nome)
                .build();
    }
}
