package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.Video;

//Criacao dos objetos separadamente, Single Resposability Principle, Facilitar testes unitarios
public class VideoFactory implements IVideoFactory {
    @Override
    public Video create(String titulo, String descricao, String url, String category) {
        return new Video(titulo, descricao, url, category);
    }
}
