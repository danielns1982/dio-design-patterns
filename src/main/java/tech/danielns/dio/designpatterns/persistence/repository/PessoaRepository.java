package tech.danielns.dio.designpatterns.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.danielns.dio.designpatterns.persistence.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
