package br.com.fiap.fase4streamingvideos.domain;

import java.time.LocalDate;

public interface IVideo {
    Long getId();
    String getTitle();
    String getDescription();
    String getUrl();
    LocalDate getCreatedAt();
    String getCategory();
}
