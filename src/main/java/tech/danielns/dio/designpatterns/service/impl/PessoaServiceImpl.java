package tech.danielns.dio.designpatterns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.danielns.dio.designpatterns.dto.CriarPessoaDto;
import tech.danielns.dio.designpatterns.persistence.model.Filme;
import tech.danielns.dio.designpatterns.persistence.model.Pessoa;
import tech.danielns.dio.designpatterns.persistence.repository.FilmeRepository;
import tech.danielns.dio.designpatterns.persistence.repository.PessoaRepository;
import tech.danielns.dio.designpatterns.service.OmdbService;
import tech.danielns.dio.designpatterns.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private OmdbService omdbService;

    public Iterable<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa create(CriarPessoaDto criarPessoaDto) {
        String imdbId = criarPessoaDto.getImdbId();
        Filme filme = filmeRepository.findByImdbId(imdbId).orElseGet(() -> {
            Filme novoFilme = omdbService.getMovieByImdbId(imdbId);
            filmeRepository.save(novoFilme);

            return novoFilme;
        });

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(criarPessoaDto.getNome());
        pessoa.setFilmePreferido(filme);

        return pessoaRepository.save(pessoa);
    }
}
