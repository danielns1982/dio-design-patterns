package tech.danielns.dio.designpatterns.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String imdbId;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column
    private String ano;

    @Column
    private String pais;

    public Filme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdbID")
    public void setImdbId(String imdbID) {
        this.imdbId = imdbID;
    }

    @JsonProperty("titulo")
    public String getTitulo() {
        return titulo;
    }

    @JsonProperty("Title")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("ano")
    public String getAno() {
        return ano;
    }

    @JsonProperty("Year")
    public void setAno(String ano) {
        this.ano = ano;
    }

    @JsonProperty("pais")
    public String getPais() {
        return pais;
    }

    @JsonProperty("Country")
    public void setPais(String pais) {
        this.pais = pais;
    }

}
