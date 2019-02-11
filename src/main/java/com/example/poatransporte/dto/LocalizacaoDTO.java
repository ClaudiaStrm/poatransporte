package com.example.poatransporte.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
