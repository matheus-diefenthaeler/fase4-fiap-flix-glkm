package br.com.fiap.fase4streamingvideos.domain;

import java.time.LocalDate;

public interface IVideo {
    String getTitle();

    String getDescription();

    String getUrl();

    LocalDate getCreatedAt();

    String getCategory();

    Long getViews();
}
