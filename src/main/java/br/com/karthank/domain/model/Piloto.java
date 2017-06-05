package br.com.karthank.domain.model;

public class Piloto {

    private long id;
    private String nome;

    public Piloto(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
