package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class UserMongoDB {

    @Id
    private String id;
    private String name;
    private String email;
    private List<VideoMongoDB> favoriteVideos = new ArrayList<>();

    public UserMongoDB(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<VideoMongoDB> getFavoriteVideos() {
        return favoriteVideos;
    }

    public void setFavoriteVideos(List<VideoMongoDB> favoriteVideos) {
        this.favoriteVideos = favoriteVideos;
    }

    @Override
    public String toString() {
        return "UserMongoDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", favoriteVideos=" + favoriteVideos +
                '}';
    }
}
