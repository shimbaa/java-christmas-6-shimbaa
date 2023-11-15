package christmas;

import christmas.util.MenuInputParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuInputParserTest {
    private static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    @DisplayName("중복메뉴를 입력하면 예외가 발생한다")
    @Test
    void menuByDuplicateName() {
        Assertions.assertThatThrownBy(
                        () -> MenuInputParser.getMenuInputForms("초코케이크-1, 초코케이크-2")
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName("중복이 아닌 메뉴를 입력하면 예외가 발생하지 않는다")
    @Test
    void menuByUniqueName() {
        Assertions.assertThatCode(
                        () -> MenuInputParser.getMenuInputForms("초코케이크-1, 티본스테이크-1")
                ).doesNotThrowAnyException();
    }
}
