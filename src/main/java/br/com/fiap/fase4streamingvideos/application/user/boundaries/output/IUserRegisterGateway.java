package br.com.fiap.fase4streamingvideos.application.user.boundaries.output;

import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoExistsGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IUser;
import br.com.fiap.fase4streamingvideos.domain.IVideo;

public interface IUserRegisterGateway {
    UserResponseModel save(IUser iUser);
}
