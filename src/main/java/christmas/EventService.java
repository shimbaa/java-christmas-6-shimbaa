package christmas;

import christmas.discount.Event;
import christmas.order.Order;
import christmas.order.OrderedMenus;
import christmas.order.VisitingDate;
import java.util.HashMap;
import java.util.Map;

public class EventService {

    private static final int CHRISTMAS_DAY = 25;
    private final Map<Event, Integer> totalBenefit = new HashMap<>();

    public void applyDiscount(Order order) {
        OrderedMenus orderedMenus = order.getOrderedMenus();
        VisitingDate visitingDate = order.getVisitingDate();

        applyChristMasDiscount(visitingDate);
        applyWeekDayDiscount(orderedMenus, visitingDate);
        applyWeekEndDiscount(orderedMenus, visitingDate);

    }

    private void applyChristMasDiscount(VisitingDate visitingDate) {
        if (visitingDate.isInChristmasEventRange()) {
            int discountAmount = 900 + (CHRISTMAS_DAY - (visitingDate.getDDayUntilChristmas()) * 100);
            totalBenefit.put(Event.CHRISTMAS_DISCOUNT, discountAmount);
        }
    }

    private void applyWeekDayDiscount(OrderedMenus orderedMenus, VisitingDate visitingDate) {
        if (orderedMenus.countDessertMenu() != 0 && visitingDate.isWeekDayEventRange()) {
            int dessertMenuCount = orderedMenus.countDessertMenu();
            int discountAmount = dessertMenuCount * 2_023;
            totalBenefit.put(Event.WEEKDAY_DISCOUNT, discountAmount);
        }
    }

    private void applyWeekEndDiscount(OrderedMenus orderedMenus, VisitingDate visitingDate) {
        if (orderedMenus.countMainMenu() != 0 && visitingDate.isWeekendEventRange()) {
            int mainMenuCount = orderedMenus.countMainMenu();
            int discountAmount = mainMenuCount * 2_023;
            totalBenefit.put(Event.WEEKEND_DISCOUNT, discountAmount);
        }
    }
}