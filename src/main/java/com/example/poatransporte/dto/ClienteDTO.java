package com.example.poatransporte.dto;

import com.example.poatransporte.entity.Cliente;
import com.example.poatransporte.entity.Linha;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("nome")
    public String nome;
    @JsonProperty("cpf")
    public String cpf;

    @JsonProperty("linhas")
    public List<Linha> linhas;

    public Cliente mapToCliente() {
        return Cliente.builder()
                .id(this.id)
                .nome(this.nome)
                .cpf(this.cpf)
                .build();
    }

}
