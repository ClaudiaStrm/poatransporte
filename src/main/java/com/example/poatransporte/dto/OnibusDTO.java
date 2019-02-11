package com.example.poatransporte.dto;

import com.example.poatransporte.entity.Onibus;
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
public class OnibusDTO {

        @JsonProperty("idlinha")
        public Long idLinha;
        @JsonProperty("nome")
        public String nome;
        @JsonProperty("codigo")
        public String codigo;
        @JsonIgnore
        public Map<String, LocalizacaoDTO> latLongMap = new HashMap<>();

        @JsonAnyGetter
        public Map<String, LocalizacaoDTO> getLatLongMap() {
            return this.latLongMap;
        }

        @JsonAnySetter
        public void setLatLongMap(String name, LocalizacaoDTO value) {
            latLongMap.put(name, value);
        }

        public Onibus mapToOnibus() {
                return Onibus.builder().id(this.getIdLinha()).nome(this.getNome()).codigo(this.getCodigo()).build();
        }
}
