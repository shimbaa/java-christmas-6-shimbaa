package christmas.view;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    public void printOrderedMenu(List<MenuInputForm> menuInputForms) {
        System.out.println("<주문 메뉴>");
        menuInputForms.forEach(menuInputForm ->
                System.out.printf("%s %d개\n", menuInputForm.getMenuName(), menuInputForm.getMenuQuantity()));
    }

    public void printTotalOrderPriceBeforeDiscount(int totalPrice) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        DecimalFormat df = new DecimalFormat("#,###");
        String format = df.format(totalPrice);
        System.out.println(format + "원");
    }
}