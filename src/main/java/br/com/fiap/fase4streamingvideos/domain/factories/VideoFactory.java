package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.Video;

import java.time.LocalDate;
//Criacao dos objetos separadamente, Single Resposability Principle, Facilitar testes unitarios
public class VideoFactory implements IVideoFactory {
    @Override
    public Video create(String titulo, String descricao, String url, LocalDate dataPublicacao, String category) {
        return new Video(titulo, descricao, url, dataPublicacao, category);
    }
}
