package br.com.fiap.fase4streamingvideos.application.user.exception;

public class UserCustomException extends RuntimeException{

    public UserCustomException() {
    }

    public UserCustomException(String message) {
        super(message);
    }

    public UserCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
