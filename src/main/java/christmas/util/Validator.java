package christmas.util;

import org.junit.platform.commons.util.StringUtils;

public class Validator {
    private static final String BLANK_INPUT = "[ERROR] 잘못된 입력값입니다.(빈칸 혹은 공백)";
    private static final String NOT_INTEGER_INPUT = "[ERROR] 정수만 입력해 주세요.";

    public static void validateIsBlank(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }

    public static void validateIsInteger(String value) {
        if (!isInteger(value)) {
            throw new IllegalArgumentException(NOT_INTEGER_INPUT);
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
