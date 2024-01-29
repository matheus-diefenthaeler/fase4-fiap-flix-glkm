package br.com.fiap.fase4streamingvideos.application.favorite.model.response;

import java.time.LocalDate;

public class FavoriteResponseModel {
    private String id;

    private String idUser;
    private String idVideo;
    private String nameVideo;
    private String addedAt;

    public FavoriteResponseModel() {}

    public FavoriteResponseModel(String id, String idUser, String idVideo, String nameVideo, String addedAt) {
        this.id = id;
        this.idUser = idUser;
        this.idVideo = idVideo;
        this.nameVideo = nameVideo;
        this.addedAt = addedAt;
    }

    public FavoriteResponseModel(String idUser, String idVideo, String nameVideo, String addedAt) {
        this.idUser = idUser;
        this.idVideo = idVideo;
        this.nameVideo = nameVideo;
        this.addedAt = addedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }
}
