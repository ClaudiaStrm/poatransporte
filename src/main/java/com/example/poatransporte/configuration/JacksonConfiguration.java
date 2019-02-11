package com.example.poatransporte.configuration;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfiguration {

    @Autowired
    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Bean
    public ObjectMapper objectMapper() {
        return jackson2ObjectMapperBuilder
                .createXmlMapper(false)
                .modulesToInstall(new JavaTimeModule())
                .build()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

}