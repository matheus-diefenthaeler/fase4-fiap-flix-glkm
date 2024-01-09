package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.IVideo;

import java.time.LocalDate;

public interface IVideoFactory {
    IVideo create(String titulo, String descricao, String url, LocalDate dataPublicacao, String category);
}
