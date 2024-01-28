package br.com.fiap.fase4streamingvideos.application.favorite.exception;

public class FavoriteCustomException extends RuntimeException{
    public FavoriteCustomException() {
    }

    public FavoriteCustomException(String message) {
        super(message);
    }

    public FavoriteCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
