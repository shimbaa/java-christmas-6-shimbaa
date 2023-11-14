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

        if (visitingDate.isInChristmasEventRange()) {
            int discountAmount = 900 + (CHRISTMAS_DAY - (visitingDate.getDDayUntilChristmas()) * 100);
            totalBenefit.put(Event.CHRISTMAS_DISCOUNT, discountAmount);
        }

        if (orderedMenus.countDessertMenu() != 0 && visitingDate.isWeekDayEventRange()) {
            int dessertMenuCount = orderedMenus.countDessertMenu();
            int discountAmount = dessertMenuCount * 2_023;
            totalBenefit.put(Event.WEEKDAY_DISCOUNT, discountAmount);
        }
    }
}