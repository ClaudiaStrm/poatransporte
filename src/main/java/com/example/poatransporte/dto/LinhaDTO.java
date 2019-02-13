package com.example.poatransporte.dto;

import com.example.poatransporte.entity.Linha;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idlinha",
        "nome",
        "codigo"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinhaDTO {

        @JsonProperty("id")
        public Long id;
        @JsonProperty("idlinha")
        public Long idLinha;
        @JsonProperty("nome")
        public String nome;
        @JsonProperty("codigo")
        public String codigo;
        @JsonIgnore
        public Map<String, LocalizacaoDTO> itinerario = new HashMap<>();

        @JsonAnyGetter
        public Map<String, LocalizacaoDTO> getItinerario() {
            return this.itinerario;
        }

        @JsonAnySetter
        public void setItinerario(String name, LocalizacaoDTO value) {
                itinerario.put(name, value);
        }

        public Linha mapToLinha() {
                return Linha
                        .builder()
                        .id((this.getIdLinha() != null ? this.getIdLinha() : this.getId()))
                        .nome(this.getNome())
                        .codigo(this.getCodigo())
                        .build();
        }
}
