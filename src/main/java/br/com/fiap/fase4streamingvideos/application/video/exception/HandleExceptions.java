package br.com.fiap.fase4streamingvideos.application.video.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice

public class HandleExceptions {
    private final Instant timestamp = Instant.now();

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(VideoCustomException.class)
    public Map<String, String> handleConflict(VideoCustomException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("timestamp", timestamp.toString());
        errors.put("message", ex.getMessage());

        ex.printStackTrace();
        return errors;
    }
}
