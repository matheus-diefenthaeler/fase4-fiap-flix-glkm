package br.com.fiap.fase4streamingvideos.adapter.gateways.mapper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJpaMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFavoriteVideo> favoriteVideos = new ArrayList<>();

    public UserJpaMapper(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
