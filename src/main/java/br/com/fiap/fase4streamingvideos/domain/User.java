package br.com.fiap.fase4streamingvideos.domain;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser{

    private String name;
    private String email;
    private List<String> filmesFavoritos;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.filmesFavoritos = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public List<String> getFilmesFavoritos() {
        return filmesFavoritos;
    }
}
