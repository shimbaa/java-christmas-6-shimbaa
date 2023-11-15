package christmas.view;

import java.util.List;

public class OutputView {

    public void printOrderedMenu(List<MenuInputForm> menuInputForms) {
        System.out.println("<주문 메뉴>");
        menuInputForms.forEach(menuInputForm ->
                System.out.printf("%s %d개\n", menuInputForm.getMenuName(), menuInputForm.getMenuQuantity()));
    }
}