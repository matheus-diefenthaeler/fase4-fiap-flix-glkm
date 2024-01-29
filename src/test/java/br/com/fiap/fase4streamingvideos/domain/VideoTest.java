package br.com.fiap.fase4streamingvideos.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;

public class VideoTest {
    @Test
    void shouldTitleBeEquals() {
        Video video = new Video("Inception", "Mind-bending movie", "http://example.com/inception", "Sci-Fi");
        String title = video.getTitle();
        Assertions.assertThat(title).isEqualTo("Inception");
    }

    @Test
    void shouldDescriptionBeEquals() {
        Video video = new Video("The Dark Knight", "Action-packed superhero film", "http://example.com/darkknight", "Action");
        String description = video.getDescription();
        Assertions.assertThat(description).isEqualTo("Action-packed superhero film");
    }

    @Test
    void shouldUrlBeEquals() {
        Video video = new Video("The Shawshank Redemption", "Inspiring prison drama", "http://example.com/shawshank", "Drama");
        String url = video.getUrl();
        Assertions.assertThat(url).isEqualTo("http://example.com/shawshank");
    }

    @Test
    void shouldCreatedAtNotBeNull() {
        Video video = new Video("The Godfather", "Classic crime film", "http://example.com/godfather", "Crime");
        LocalDate createdAt = video.getCreatedAt();
        Assertions.assertThat(createdAt).isNotNull();
    }

    @Test
    void shouldCategoryBeEquals() {
        Video video = new Video("Pulp Fiction", "Quirky crime film", "http://example.com/pulpfiction", "Crime");
        String category = video.getCategory();
        Assertions.assertThat(category).isEqualTo("Crime");
    }

    @Test
    void shouldNotExistSetterToTitle() {
        Class<?> videoClass = Video.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = videoClass.getMethod("setTitle");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToDescription() {
        Class<?> videoClass = Video.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = videoClass.getMethod("setDescription");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToUrl() {
        Class<?> videoClass = Video.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = videoClass.getMethod("setUrl");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToCreatedAt() {
        Class<?> videoClass = Video.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = videoClass.getMethod("setCreatedAt");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void shouldNotExistSetterToCategory() {
        Class<?> videoClass = Video.class;
        Throwable throwable = Assertions.catchThrowable(() -> {
            Method method = videoClass.getMethod("setCategory");
        });

        Assertions.assertThat(throwable).isInstanceOf(NoSuchMethodException.class);
    }
}
