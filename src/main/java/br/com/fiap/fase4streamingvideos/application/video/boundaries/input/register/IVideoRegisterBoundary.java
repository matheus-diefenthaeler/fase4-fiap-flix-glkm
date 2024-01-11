package br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;

public interface IVideoRegisterBoundary {

    VideoResponseModel create(VideoRequestModel requestModel) throws VideoCustomException;
}
