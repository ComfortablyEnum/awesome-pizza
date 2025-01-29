package com.awesomepizza;

public class Ordine {
    private long id;
    private String nomePizza;
    private String status;

    public Ordine(long id, String nomePizza, String status) {
        this.id = id;
        this.nomePizza = nomePizza;
        this.status = status;
    }

    public long getId() { return id; }
    public String getNomePizza() { return nomePizza; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
