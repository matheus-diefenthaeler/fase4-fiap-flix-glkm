package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.User;

public class UserFactory implements IUserFactory{
    @Override
    public User create(String name, String email) {
        return new User(name, email);
    }
}
