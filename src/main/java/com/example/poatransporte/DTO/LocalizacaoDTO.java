package com.example.poatransporte.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lng"
})
public class LocalizacaoDTO {

    @JsonProperty("lat")
    public String lat;
    @JsonProperty("lng")
    public String lng;

}
