package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserFactoryTest {
    @Test
    public void shouldUserAttributesBeEquals() {
        UserFactory userFactory = new UserFactory();
        User user = userFactory.create("John", "john@example.com");

        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getName()).isEqualTo("John");
        Assertions.assertThat(user.getEmail()).isEqualTo("john@example.com");
    }
}
