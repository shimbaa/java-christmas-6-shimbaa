package christmas;

import christmas.event.EventService;
import christmas.order.Order;
import christmas.order.OrderedMenus;
import christmas.order.VisitingDate;
import christmas.view.InputView;
import christmas.view.MenuInputForm;
import christmas.view.OutputView;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final EventService eventService = new EventService();
    private List<MenuInputForm> menuInputForms;

    public void run() {
        inputView.printHelloMessage();

        VisitingDate visitingDate = getVisitingDate();

        OrderedMenus orderedMenus = getOrderedMenus();

        Order order = new Order(visitingDate, orderedMenus);

        outputView.printOrderedMenu(menuInputForms);
        outputView.printTotalOrderPriceBeforeDiscount(orderedMenus.getTotalPrice());

        eventService.applyDiscount(order);
    }

    private VisitingDate getVisitingDate() {
        try {
            int visitingDateInput = inputView.getVisitingDate();
            return VisitingDate.from(visitingDateInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getVisitingDate();
        }
    }

    private OrderedMenus getOrderedMenus() {
        try {
            menuInputForms = inputView.getMenuAndQuantity();
            List<String> menuItemInput = createMenuItemInput(menuInputForms);
            return OrderedMenus.of(menuItemInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getOrderedMenus();
        }
    }

    private List<String> createMenuItemInput(List<MenuInputForm> menuInputForms) {
        return menuInputForms.stream()
                .flatMap(this::createMenuItems)
                .toList();
    }

    private Stream<String> createMenuItems(MenuInputForm menuInputForm) {
        String menuName = menuInputForm.getMenuName();
        int menuQuantity = menuInputForm.getMenuQuantity();

        return Collections.nCopies(menuQuantity, menuName).stream();
    }
}