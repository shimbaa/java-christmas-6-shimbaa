package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.Validator;
import christmas.util.MenuInputParser;
import java.util.List;

public class InputView {

    private static final String HELLO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String REQUEST_VISITING_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String REQUEST_MENU_AND_QUANTITY = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public void printHelloMessage() {
        System.out.println(HELLO_MESSAGE);
    }

    public int getVisitingDate() {
        System.out.println(REQUEST_VISITING_DATE);
        String input = Console.readLine();
        Validator.validateIsBlankForVisitingDate(input);
        Validator.validateIsIntegerForVisitingDate(input);
        return Integer.parseInt(input);
    }

    public List<MenuInputForm> getMenuAndQuantity() {
        System.out.println(REQUEST_MENU_AND_QUANTITY);
        String input = Console.readLine();
        return MenuInputParser.getMenuInputForms(input);
    }
}