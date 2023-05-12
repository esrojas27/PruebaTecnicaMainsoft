package org.example.persistance.entity;

public class PokemonEntity {
    private int id;
    private String name;
    private String url;

    public PokemonEntity(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public PokemonEntity(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PokemonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
