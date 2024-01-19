package br.com.fiap.fase4streamingvideos.domain;

import java.util.List;

public interface IUser {

    String getName();
    String getEmail();
    List<String> getFilmesFavoritos();

}
