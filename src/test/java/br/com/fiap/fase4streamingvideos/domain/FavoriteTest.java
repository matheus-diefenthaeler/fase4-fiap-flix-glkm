package br.com.fiap.fase4streamingvideos.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

public class FavoriteTest {
    @Test
    void shouldIdVideoBeEquals() {
        Favorite favorite = new Favorite("1", "user123", "Inception");
        String idVideo = favorite.getIdVideo();
        Assertions.assertThat(idVideo).isEqualTo("user123");
    }

    @Test
    void shouldIdUserBeEquals() {
        Favorite favorite = new Favorite("2", "user456", "The Dark Knight");
        String idUser = favorite.getIdUser();
        Assertions.assertThat(idUser).isEqualTo("2");
    }

    @Test
    void shouldNameVideoBeEquals() {
        Favorite favorite = new Favorite("3", "user789", "The Shawshank Redemption");
        String nameVideo = favorite.getNameVideo();
        Assertions.assertThat(nameVideo).isEqualTo("The Shawshank Redemption");
    }

    @Test
    void shouldAddedAtNotBeNull() {
        Favorite favorite = new Favorite("4", "user101", "The Godfather");
        LocalDate addedAt = favorite.getAddedAt();
        Assertions.assertThat(addedAt).isNotNull();
    }

    @Test
    void shouldNotExistSetterToIdVideo() {
        Class<?> favoriteClass = Favorite.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = favoriteClass.getMethod("setIdVideo");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToIdUser() {
        Class<?> favoriteClass = Favorite.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = favoriteClass.getMethod("setIdUser");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToNameVideo() {
        Class<?> favoriteClass = Favorite.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = favoriteClass.getMethod("setNameVideo");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToAddedAt() {
        Class<?> favoriteClass = Favorite.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = favoriteClass.getMethod("setAddedAt");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }
}
