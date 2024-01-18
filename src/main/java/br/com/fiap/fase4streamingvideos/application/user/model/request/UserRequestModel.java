package br.com.fiap.fase4streamingvideos.application.user.model.request;

public class UserRequestModel {

    private String name;
    private String email;

    public UserRequestModel(String name, String email) {
        this.name = name;
        this.email = email;
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
}
