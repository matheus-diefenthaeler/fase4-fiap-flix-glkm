package br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output;

import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface IGetAllFavoriteGateway{
    Flux<FavoriteResponseModel> findAllByIdUser(String id);
}
