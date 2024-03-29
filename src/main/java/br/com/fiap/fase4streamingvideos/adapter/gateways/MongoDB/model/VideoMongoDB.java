package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "videos")
public class VideoMongoDB {

    @Id
    private String id;
    private String title;
    private String description;
    private String url;
    private LocalDate createdAt;
    private String category;
    private Long views;

    public VideoMongoDB() {}

    public VideoMongoDB(String title, String description, String url, LocalDate createdAt, String category, Long views) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
        this.category = category;
        this.views = views;
    }

    public VideoMongoDB(String title, String description, String url, String category) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
        this.views = 0L;
    }


    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void incrementViews(){
        this.views++;
    }

    @Override
    public String toString() {
        return "VideoMongoDB{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", createdAt=" + createdAt +
                ", category='" + category + '\'' +
                '}';
    }
}
