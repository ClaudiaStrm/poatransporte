package com.example.poatransporte.service;

import com.example.poatransporte.DTO.OnibusDTO;
import com.example.poatransporte.entity.Onibus;
import com.example.poatransporte.repository.OnibusRepository;
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
import java.util.List;

@Service
public class OnibusService {

    @Autowired
    private OnibusRepository onibusRepository;

    public Page<Onibus> buscarLinhas(Pageable pageable) throws IOException {

        URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o");
        InputStream json = url.openStream();

        Gson gson = new Gson();
        Type tipoListaOnibus = new TypeToken<List<Onibus>>(){}.getType();
        InputStreamReader in = new InputStreamReader(json, "UTF-8");
        List<Onibus> onibusLista = gson.fromJson(new InputStreamReader(json, "UTF-8"), tipoListaOnibus);

        return new PageImpl<>(
                onibusLista,
                pageable,
                onibusLista.size());
    }

    public OnibusDTO buscarPorId(Long id) throws IOException {

        URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + id);
        InputStream json = url.openStream();

        Gson gson = new Gson();
        OnibusDTO onibus = gson.fromJson(new InputStreamReader(json, "UTF-8"), OnibusDTO.class);

        return onibus;
    }

}
