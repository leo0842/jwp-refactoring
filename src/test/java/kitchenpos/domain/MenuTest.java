package kitchenpos.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void menu를_생성할_수_있다() {
        Menu menu = new Menu(1L, "pasta", BigDecimal.valueOf(13000), 1L, new ArrayList<>());
        Assertions.assertAll(
                () -> assertThat(menu.getId()).isEqualTo(1L),
                () -> assertThat(menu.getName()).isEqualTo("pasta"),
                () -> assertThat(menu.getPrice()).isEqualTo(BigDecimal.valueOf(13000)),
                () -> assertThat(menu.getMenuGroupId()).isEqualTo(1L),
                () -> assertThat(menu.getMenuProducts()).hasSize(0)
        );
    }

    @Test
    void price가_null이면_예외를_반환한다() {
        BigDecimal nullPrice = null;
        assertThatThrownBy(() -> new Menu(1L, "pasta", nullPrice, 1L, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void price가_음수이면_예외를_반환한다() {
        BigDecimal negativePrice = BigDecimal.valueOf(-1000);
        assertThatThrownBy(() -> new Menu(1L, "pasta", negativePrice, 1L, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}