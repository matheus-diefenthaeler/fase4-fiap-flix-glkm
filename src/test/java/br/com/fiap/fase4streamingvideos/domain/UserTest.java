package br.com.fiap.fase4streamingvideos.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class UserTest {
    @Test
    void shouldNameBeEquals() {
        User user = new User("John", "john@example.com");
        String name = user.getName();
        Assertions.assertThat(name).isEqualTo("John");
    }

    @Test
    void shouldEmailBeEquals() {
        User user = new User("Jane", "jane@example.com");
        String email = user.getEmail();
        Assertions.assertThat(email).isEqualTo("jane@example.com");
    }

    @Test
    void shouldFilmesFavoritosBeInitiallyEmpty() {
        User user = new User("Alice", "alice@example.com");
        List<String> filmesFavoritos = user.getFilmesFavoritos();
        Assertions.assertThat(filmesFavoritos).isEmpty();
    }

    @Test
    void shouldAddFilmeToFavoritos() {
        User user = new User("Bob", "bob@example.com");
        user.getFilmesFavoritos().add("Inception");
        Assertions.assertThat(user.getFilmesFavoritos()).containsExactly("Inception");
    }

    @Test
    void shouldAddMultipleFilmesToFavoritos() {
        User user = new User("Charlie", "charlie@example.com");
        user.getFilmesFavoritos().addAll(Arrays.asList("The Shawshank Redemption", "The Dark Knight"));
        Assertions.assertThat(user.getFilmesFavoritos())
                .containsExactly("The Shawshank Redemption", "The Dark Knight");
    }

    @Test
    void shouldNotExistSetterToName() {
        Class<?> userClass = User.class;

        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = userClass.getMethod("setName");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToEmail() {
        Class<?> userClass = User.class;

        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = userClass.getMethod("setEmail");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToFilmesFavoritos() {
        Class<?> userClass = User.class;

        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = userClass.getMethod("setFilmesFavoritos");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }
}
