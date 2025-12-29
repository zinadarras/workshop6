package com.example.myapplication;

public class Offre {
    private int id;
    private String poste;
    private String description;

    public Offre(int id, String poste, String description) {
        this.id = id;
        this.poste = poste;
        this.description = description;
    }

    public Offre(String poste, String description) {
        this.poste = poste;
        this.description = description;
    }

    public int getId() { return id; }
    public String getPoste() { return poste; }
    public String getDescription() { return description; }

    public void setPoste(String poste) { this.poste = poste; }
    public void setDescription(String description) { this.description = description; }
}
