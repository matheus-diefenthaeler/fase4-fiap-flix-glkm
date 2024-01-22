package br.com.fiap.fase4streamingvideos.adapter.gateways.h2;

import br.com.fiap.fase4streamingvideos.adapter.repository.IVideoRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IDeleteVideoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteVideoH2Gateway implements IDeleteVideoGateway {

    @Autowired
    IVideoRepository _repository;

    public DeleteVideoH2Gateway() {}

    @Override
    public void deleteById(Long id) {
        _repository.deleteById(id);
    }
}
