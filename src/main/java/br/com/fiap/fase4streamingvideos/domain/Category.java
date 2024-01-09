package br.com.fiap.fase4streamingvideos.domain;

public enum Category {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    SCIENCE_FICTION("Science Fiction");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
