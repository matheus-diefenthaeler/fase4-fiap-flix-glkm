package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.IUser;

public interface IUserFactory {
    IUser create(String name, String email);
}
