package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.IVideo;

public interface IVideoFactory {
    IVideo create(String titulo, String descricao, String url, String category);
}
