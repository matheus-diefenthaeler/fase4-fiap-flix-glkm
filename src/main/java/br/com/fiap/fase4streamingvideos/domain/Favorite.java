package br.com.fiap.fase4streamingvideos.domain;

import java.time.LocalDate;

public class Favorite implements IFavorite {
    private String idVideo;
    private String idUser;
    private String nameVideo;
    private LocalDate addedAt;

    public Favorite(String idVideo, String idUser, String nameVideo) {
        this.idVideo = idVideo;
        this.idUser = idUser;
        this.nameVideo = nameVideo;
        this.addedAt = LocalDate.now();
    }

    @Override
    public String getIdVideo() {
        return idVideo;
    }

    @Override
    public String getIdUser() {
        return idUser;
    }

    @Override
    public String getNameVideo() {
        return nameVideo;
    }

    @Override
    public LocalDate getAddedAt() { return addedAt; }
}
