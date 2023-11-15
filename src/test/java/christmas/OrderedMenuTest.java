package christmas;

import static org.assertj.core.api.Assertions.*;

import christmas.order.OrderedMenus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedMenuTest {
    private static final String ONLY_BEVERAGE = "[ERROR] 음료만 주문 시, 주문할 수 없습니다.";

    @DisplayName("음료만 주문시 주문할 수 없고, 예외가 발생한다")
    @Test
    void createOrderedMenusByOnlyBeverage() {
        assertThatThrownBy(
                () -> OrderedMenus.of(List.of("제로콜라", "레드와인", "샴페인"))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_BEVERAGE);
    }

    @DisplayName("음료외 다른 카테고리 메뉴가 포함될 시 주문가능하고 예외가 발생하지 않는다")
    @Test
    void createOrderedMenusByNotOnlyBeverage() {
        assertThatCode(
                () -> OrderedMenus.of(List.of("제로콜라", "레드와인", "샴페인", "양송이수프"))
        ).doesNotThrowAnyException();
    }
}
