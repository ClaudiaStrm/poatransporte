package com.example.poatransporte.dto;

import com.example.poatransporte.entity.Localizacao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lng"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoDTO {

    @JsonProperty("lat")
    public String lat;
    @JsonProperty("lng")
    public String lng;

    public Long idLinha;


    public Localizacao mapToLocalizacao() {
        return Localizacao
                .builder()
                .latitude(this.lat)
                .longitude(this.lng)
                .build();
    }
}
