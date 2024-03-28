package tech.danielns.dio.designpatterns.service;

import org.springframework.stereotype.Service;

import tech.danielns.dio.designpatterns.dto.CriarPessoaDto;
import tech.danielns.dio.designpatterns.persistence.model.Pessoa;

@Service
public interface PessoaService {
    Iterable<Pessoa> findAll();

    Pessoa create(CriarPessoaDto criarPessoaDto);
}
