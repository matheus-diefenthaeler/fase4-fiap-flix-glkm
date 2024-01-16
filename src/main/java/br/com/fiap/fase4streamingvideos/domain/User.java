package br.com.fiap.fase4streamingvideos.domain;

import java.util.List;

public class User implements IUser {

    private String name;
    private String email;
    private List<String> favorites;

    public User(String name, String email, List<String> favorites){
        this.name = name;
        this.email = email;
        this.favorites = favorites;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getFavorites() {
        return favorites;
    }

}
