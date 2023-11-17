package christmas;

import christmas.event.Event;
import christmas.event.EventBadge;
import christmas.event.EventService;
import christmas.order.Order;
import christmas.order.OrderedMenus;
import christmas.order.VisitingDate;
import christmas.view.InputView;
import christmas.view.MenuInputForm;
import christmas.view.OutputView;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final EventService eventService = new EventService();
    private List<MenuInputForm> menuInputForms;

    public void run() {
        inputView.printHelloMessage();
        Order order = new Order(getVisitingDate(), getOrderedMenus());

        printOrderedInformation(order.visitingDate(), order.orderedMenus());
        eventService.applyDiscount(order);

        printTotalBenefits();
        printTotalOrderPriceAfterDiscount(order.orderedMenus());
        printEventBadge();
    }

    private void printOrderedInformation(VisitingDate visitingDate, OrderedMenus orderedMenus) {
        outputView.printBenefitMessage(visitingDate.getVisitingDateDTO());
        outputView.printOrderedMenu(menuInputForms);
        outputView.printTotalOrderPriceBeforeDiscount(orderedMenus.getTotalPrice());
    }

    private void printTotalBenefits() {
        Map<Event, Integer> totalBenefit = eventService.getTotalBenefit();
        outputView.printPresentEvent(totalBenefit);
        outputView.printBenefitDetails(totalBenefit);
        outputView.printTotalBenefitAmount(eventService.getTotalBenefitAmount());
    }

    private void printTotalOrderPriceAfterDiscount(OrderedMenus orderedMenus) {
        int totalPrice = orderedMenus.getTotalPrice();
        int totalDiscountAmount = eventService.getTotalDiscountAmount();
        int totalPriceAfterDiscount = totalPrice - totalDiscountAmount;

        outputView.printTotalOrderPriceAfterDiscount(totalPriceAfterDiscount);
    }

    private void printEventBadge() {
        int totalBenefitAmount = eventService.getTotalBenefitAmount();
        EventBadge eventBadge = EventBadge.of(totalBenefitAmount);
        outputView.printEventBadge(eventBadge);
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