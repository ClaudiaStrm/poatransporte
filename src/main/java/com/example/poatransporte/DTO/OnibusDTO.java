package com.example.poatransporte.DTO;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idlinha",
        "nome",
        "codigo"
})
public class OnibusDTO {

    @JsonProperty("idlinha")
    public String id;
    @JsonProperty("nome")
    public String nome;
    @JsonProperty("codigo")
    public String codigo;
    @JsonIgnore
    private Map<Long, LocalizacaoDTO> latLongMap = new HashMap<Long, LocalizacaoDTO>();

    @JsonAnyGetter
    public Map<Long, LocalizacaoDTO> getLatLongMap() {
        return this.latLongMap;
    }

    @JsonAnySetter
    public void setLatLongMap(Long name, LocalizacaoDTO value) {
        this.latLongMap.put(name, value);
    }
}