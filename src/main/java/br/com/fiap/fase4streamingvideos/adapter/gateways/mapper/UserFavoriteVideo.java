package br.com.fiap.fase4streamingvideos.adapter.gateways.mapper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_favorite_videos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFavoriteVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJpaMapper user;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private VideoJpaMapper video;

    private String userName;
    private String videoTitle;
}
