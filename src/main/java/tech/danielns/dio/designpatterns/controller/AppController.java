package tech.danielns.dio.designpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import tech.danielns.dio.designpatterns.dto.CriarPessoaDto;
import tech.danielns.dio.designpatterns.persistence.model.Pessoa;
import tech.danielns.dio.designpatterns.service.impl.PessoaServiceImpl;

@RestController
public class AppController {
    @Autowired
    private PessoaServiceImpl pessoaService;

    @GetMapping("/pessoas")
    public Iterable<Pessoa> findAllPessoas() {
        return pessoaService.findAll();
    }

    @PostMapping("/pessoas")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa createPessoa(@RequestBody CriarPessoaDto criarPessoaDto) {
        try {
            return pessoaService.create(criarPessoaDto);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Imdb ID is invalid", ex);
        }
    }
}
