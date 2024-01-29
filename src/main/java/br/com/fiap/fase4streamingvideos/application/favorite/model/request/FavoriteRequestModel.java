package br.com.fiap.fase4streamingvideos.application.favorite.model.request;

public class FavoriteRequestModel {
    private String idUser;
    private String idVideo;

    public FavoriteRequestModel(String idUser, String idVideo) {
        this.idUser = idUser;
        this.idVideo = idVideo;
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
}
