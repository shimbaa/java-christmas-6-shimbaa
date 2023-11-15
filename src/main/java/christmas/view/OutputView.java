package christmas.view;

import christmas.event.Event;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printOrderedMenu(List<MenuInputForm> menuInputForms) {
        System.out.println("<주문 메뉴>");
        menuInputForms.forEach(menuInputForm ->
                System.out.printf("%s %d개\n", menuInputForm.getMenuName(), menuInputForm.getMenuQuantity()));
    }

    public void printTotalOrderPriceBeforeDiscount(int totalPrice) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(getDecimalFormat(totalPrice) + "원");
    }

    public void printPresentEvent(Map<Event, Integer> totalBenefit) {
        System.out.println("<증정 메뉴>");
        Integer benefit = totalBenefit.getOrDefault(Event.PRESENT_EVENT, 0);
        if (benefit == 0) {
            System.out.println("없음");
        }
        if (benefit != 0) {
            System.out.println(getDecimalFormat(benefit));
        }
    }

    private String getDecimalFormat(int number) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(number);
    }
}