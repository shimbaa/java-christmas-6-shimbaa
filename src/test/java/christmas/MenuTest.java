package christmas;

import christmas.menu.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    private static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    @DisplayName("메뉴판에 있는 음식을 주문시 정상실행")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크",
    "아이스크림", "제로콜라", "레드와인", "샴페인"})
    void getMenuItemByExistingMenuNames(String menuName) {
        Menu menu = new Menu();
        Assertions.assertThatCode(
                () -> menu.getMenuItem(menuName))
                .doesNotThrowAnyException();
    }

    @DisplayName("메뉴판에 없 음식을 주문시 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"없는음식", "NOT_IN_MENU"})
    void getMenuItemByNotExistingMenuNames(String menuName) {
        Menu menu = new Menu();
        Assertions.assertThatThrownBy(
                        () -> menu.getMenuItem(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }
}
