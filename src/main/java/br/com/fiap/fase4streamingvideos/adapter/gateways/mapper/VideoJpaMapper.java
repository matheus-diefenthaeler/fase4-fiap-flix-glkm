package br.com.fiap.fase4streamingvideos.adapter.gateways.mapper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoJpaMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String url;
    private LocalDate createdAt;

    private String category;

    public VideoJpaMapper(String title, String description, String url, LocalDate createdAt, String category) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
        this.category = category;
    }
}
