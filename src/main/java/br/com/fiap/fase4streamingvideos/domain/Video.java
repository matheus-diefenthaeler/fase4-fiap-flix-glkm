package br.com.fiap.fase4streamingvideos.domain;

import java.time.LocalDate;

public class Video implements IVideo {
    private String title;
    private String description;
    private String url;
    private LocalDate createdAt;
    private String category;

    public Video(String title, String description, String url, String category) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.createdAt = LocalDate.now();
        this.category = category;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
