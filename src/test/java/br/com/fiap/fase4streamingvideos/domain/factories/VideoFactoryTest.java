package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.User;
import br.com.fiap.fase4streamingvideos.domain.Video;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VideoFactoryTest {
    @Test
    public void shouldUserAttributesBeEquals() {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.create("Inception", "Mind-bending movie", "http://example.com/inception", "Sci-Fi");

        Assertions.assertThat(video).isNotNull();
        Assertions.assertThat(video.getTitle()).isEqualTo("Inception");
        Assertions.assertThat(video.getDescription()).isEqualTo("Mind-bending movie");
        Assertions.assertThat(video.getUrl()).isEqualTo("http://example.com/inception");
        Assertions.assertThat(video.getCategory()).isEqualTo("Sci-Fi");
    }
}
