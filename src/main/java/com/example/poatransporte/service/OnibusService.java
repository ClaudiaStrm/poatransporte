package com.example.poatransporte.service;

import com.example.poatransporte.dto.OnibusDTO;
import com.example.poatransporte.entity.Onibus;
import com.example.poatransporte.repository.OnibusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class OnibusService {

    @Autowired
    private OnibusRepository onibusRepository;

    public Page<Onibus> buscarLinhas(Pageable pageable) throws IOException {

        List<Onibus> onibusLista = onibusRepository.findAll();
        List<Onibus> onibusAPI = buscarLinhasAPI();

        if (onibusLista.size() == 0) {
            for (Onibus o : onibusAPI) {
                onibusRepository.save(o);
            }
        } else {
            for (Onibus o : onibusAPI) {
                if (onibusRepository.findById(o.getId()) == null) {
                    onibusRepository.save(o);
                }
            }
        }
        return new PageImpl<>(
                onibusRepository.findAll(),
                pageable,
                onibusRepository.findAll().size());
    }

    public OnibusDTO buscarPorId(Long id) throws IOException {

        URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + id);

        ObjectMapper mapper = new ObjectMapper();
        OnibusDTO onibus = mapper.readValue(url, OnibusDTO.class);

        return onibus;
    }

    public List<Onibus> buscarLinhasAPI() throws IOException {
        URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o");
        InputStream json = url.openStream();
        Gson gson = new Gson();
        Type tipoListaOnibus = new TypeToken<List<Onibus>>(){}.getType();

        return gson.fromJson(new InputStreamReader(json, "UTF-8"), tipoListaOnibus);
    }


    private void popularBanco(ArrayList<Onibus> onibus) {
        for (Onibus o: onibus) {
            onibusRepository.save(o);
        }
    }

    public Onibus salvarOnibus(OnibusDTO dto) {
        return onibusRepository.save(dto.mapToOnibus());
    }

}
