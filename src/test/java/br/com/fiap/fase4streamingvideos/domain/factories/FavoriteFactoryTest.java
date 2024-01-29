package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.Favorite;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FavoriteFactoryTest {
    @Test
    public void shouldFavoriteAttributesBeEquals() {
        FavoriteFactory favoriteFactory = new FavoriteFactory();
        Favorite favorite = favoriteFactory.create("user123", "1", "Inception");

        Assertions.assertThat(favorite).isNotNull();
        Assertions.assertThat(favorite.getIdUser()).isEqualTo("user123");
        Assertions.assertThat(favorite.getIdVideo()).isEqualTo("1");
        Assertions.assertThat(favorite.getNameVideo()).isEqualTo("Inception");
        Assertions.assertThat(favorite.getAddedAt()).isNotNull();
    }
}
