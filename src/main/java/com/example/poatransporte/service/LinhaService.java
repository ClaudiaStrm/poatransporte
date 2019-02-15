package com.example.poatransporte.service;

import com.example.poatransporte.dto.LinhaDTO;
import com.example.poatransporte.entity.Linha;
import com.example.poatransporte.repository.ItinerarioRepository;
import com.example.poatransporte.repository.LinhaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class LinhaService extends AbstractCrudService <Linha> {

    @Autowired
    private LinhaRepository linhaRepository;

    @Autowired
    private LocalizacaoService localizacaoService;

    @Autowired
    private ItinerarioRepository itinerarioRepository;

    public List<Linha> buscarLinhas() {
        return this.findAll();
    }

    public LinhaDTO buscarPorId(Long id) {
        LinhaDTO linha = this.findById(id).get().mapToDTO();
        linha.setListaItinerario(itinerarioRepository.findByIdLinha(linha.getId()));
        return linha;
    }

    public List<Linha> buscarPorNome(String nome) {
        return linhaRepository.findByNomeIgnoreCase(nome);
    }

    @Transactional(readOnly = false)
    public List<Linha> integrarBancoComAPI() throws IOException {
        List<LinhaDTO> linhasAPI = buscarTodasAsLinhasAPI();
        for (LinhaDTO dto : linhasAPI) {
            this.save(dto.mapToLinha());
            localizacaoService.salvarLocalizacaoEItinerario(this.buscarLinhaPorIdAPI(dto.getId()));
        }
        return linhaRepository.findAll();
    }

    public LinhaDTO buscarLinhaPorIdAPI(Long id) throws IOException {
        URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, LinhaDTO.class);
    }

    public List<LinhaDTO> buscarTodasAsLinhasAPI() throws IOException {
        URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o");
        InputStream json = url.openStream();
        Gson gson = new Gson();
        Type tipoListaLinhas = new TypeToken<List<LinhaDTO>>(){}.getType();

        return gson.fromJson(new InputStreamReader(json, StandardCharsets.UTF_8), tipoListaLinhas);
    }

    @Override
    protected JpaRepository<Linha, Long> getRepository() {
        return linhaRepository;
    }
}
