package tech.danielns.dio.designpatterns.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tech.danielns.dio.designpatterns.persistence.model.Filme;

@Service
public class OmdbService {
    @Value("${omdb.key}")
    String omdbKey;

    public Filme getMovieByImdbId(String imdbId) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://www.omdbapi.com/?i=" + imdbId + "&apikey=" + omdbKey;
        Filme filme = restTemplate.getForObject(uri, Filme.class);

        return filme;
    }
}
