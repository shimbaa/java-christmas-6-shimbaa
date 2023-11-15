package christmas.util;

import org.junit.platform.commons.util.StringUtils;

public class Validator {
    private static final String INVALID_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void validateIsBlankForVisitingDate(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    public static void validateIsIntegerForVisitingDate(String value) {
        if (!isInteger(value)) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    public static void validateIsIntegerForMenuQuantity(String value) {
        if (!isInteger(value)) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private Validator() {
    }
}
