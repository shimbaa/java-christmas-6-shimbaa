package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.Validator;

public class InputView {
    public void printHelloMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public int getVisitingDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        Validator.validateIsBlank(input);
        Validator.validateIsInteger(input);
        return Integer.parseInt(input);
    }
}