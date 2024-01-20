package br.com.fiap.fase4streamingvideos.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryTest {
    @Test
    public void shouldBeDifferentEnum() {
        List<Category> categories = new ArrayList<>(Arrays.stream(Category.values()).toList());

        while (!categories.isEmpty()) {
            Category category = categories.get(0);
            categories.remove(category);

            for (Category c : categories) {
                Assertions.assertThat(category).isNotNull().isNotEqualTo(c);
            }
        }
    }

    @Test
    public void shouldBeDifferentDescription() {
        List<Category> categories = new ArrayList<>(Arrays.stream(Category.values()).toList());

        while (!categories.isEmpty()) {
            Category category = categories.get(0);
            categories.remove(category);

            for (Category c : categories) {
                Assertions.assertThat(category.getDescription()).isNotNull().isNotEqualTo(c.getDescription());
            }
        }
    }
}
