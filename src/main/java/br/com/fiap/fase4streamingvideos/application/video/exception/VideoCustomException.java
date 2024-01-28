package br.com.fiap.fase4streamingvideos.application.video.exception;

public class VideoCustomException extends RuntimeException{

    public VideoCustomException() {
    }

    public VideoCustomException(String message) { super(message); }

    public VideoCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
