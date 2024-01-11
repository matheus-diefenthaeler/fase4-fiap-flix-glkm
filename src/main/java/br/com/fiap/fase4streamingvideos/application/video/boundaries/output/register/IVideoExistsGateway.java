package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

public interface IVideoExistsGateway {

    boolean existsById(Long id);
}
