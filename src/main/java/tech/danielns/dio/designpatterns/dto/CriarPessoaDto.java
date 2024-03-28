package tech.danielns.dio.designpatterns.dto;

public class CriarPessoaDto {
    private String nome;
    private String imdbId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}