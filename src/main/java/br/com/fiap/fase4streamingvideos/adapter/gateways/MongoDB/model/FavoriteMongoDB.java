package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "favorites")
public class FavoriteMongoDB {

    @Id
    private String id;
    private String idUser;
    private String idVideo;
    private String nameVideo;
    private LocalDate addedAt;

    public FavoriteMongoDB() {}

    public FavoriteMongoDB(String id, String idUser, String idVideo, String nameVideo, LocalDate addedAt) {
        this.id = id;
        this.idUser = idUser;
        this.idVideo = idVideo;
        this.nameVideo = nameVideo;
        this.addedAt = addedAt;
    }

    public FavoriteMongoDB(String idUser, String idVideo, String nameVideo, LocalDate addedAt) {
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

    public LocalDate getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDate addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "FavoriteMongoDB{" +
                "id='" + id + '\'' +
                ", idUser='" + idUser + '\'' +
                ", idVideo='" + idVideo + '\'' +
                ", addedAt=" + addedAt +
                '}';
    }
}
