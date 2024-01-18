package br.com.fiap.fase4streamingvideos.application.user.model.response;

import java.util.List;

public class UserResponseModel {

    private Long id;
    private String name;
    private String email;
    private List<String> filmesFavoritos;

    public UserResponseModel() {
    }

    public UserResponseModel(String name, String email, List<String> filmesFavoritos) {
        this.name = name;
        this.email = email;
        this.filmesFavoritos = filmesFavoritos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getFilmesFavoritos() {
        return filmesFavoritos;
    }

    public void setFilmesFavoritos(List<String> filmesFavoritos) {
        this.filmesFavoritos = filmesFavoritos;
    }


}
