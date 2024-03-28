package tech.danielns.dio.designpatterns.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.danielns.dio.designpatterns.persistence.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Optional<Filme> findByImdbId(String imdbId);
}
