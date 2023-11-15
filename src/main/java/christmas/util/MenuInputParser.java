package christmas.util;

import christmas.view.MenuInputForm;
import java.util.List;
import java.util.stream.Stream;

public class MenuInputParser {

    private static final String COMMA = ",";
    private static final String DASH = "-";
    private static final int MINIMUM_QUANTITY = 1;
    private static final int TWO_ITEMS = 2;
    private static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static List<MenuInputForm> getMenuInputForms(String input) {
        String[] menuAndQuantityAsArray = input.split(COMMA);

        validateDuplicateMenu(menuAndQuantityAsArray);

        return Stream.of(menuAndQuantityAsArray)
                .map(MenuInputParser::createMenuInputForm)
                .toList();
    }

    private static MenuInputForm createMenuInputForm(String menuAndQuantity) {
        String[] parts = menuAndQuantity.split(DASH);

        if (parts.length != TWO_ITEMS) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }

        String menuName = parts[0].trim();
        int menuQuantity = parseMenuQuantity(parts[1].trim());

        return MenuInputForm.of(menuName, menuQuantity);
    }

    private static int parseMenuQuantity(String quantityString) {
        Validator.validateIsInteger(quantityString);
        int menuQuantity = Integer.parseInt(quantityString);
        if (menuQuantity < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
        return menuQuantity;
    }

    private static void validateDuplicateMenu(String[] menuAndQuantityAsArray) {
        long uniqueMenuNamesOnlySize = Stream.of(menuAndQuantityAsArray)
                .map(MenuInputParser::createMenuInputForm)
                .map(MenuInputForm::getMenuName)
                .distinct()
                .count();

        long originalSize = Stream.of(menuAndQuantityAsArray)
                .map(MenuInputParser::createMenuInputForm)
                .count();

        if (uniqueMenuNamesOnlySize != originalSize) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }

    }
}