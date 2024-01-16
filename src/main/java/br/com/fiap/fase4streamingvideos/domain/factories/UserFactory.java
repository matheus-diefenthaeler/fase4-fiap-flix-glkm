package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.IUser;
import br.com.fiap.fase4streamingvideos.domain.User;

import java.util.List;

public class UserFactory implements IUserFactory {

    @Override
    public IUser create(String name, String email, List<String> favorites) {
        return new User(name, email, favorites);
    }
}
