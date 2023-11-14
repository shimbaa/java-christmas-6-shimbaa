package christmas;

import christmas.discount.Event;
import christmas.menu.MenuCategory;
import christmas.order.Order;
import christmas.order.OrderedMenus;
import christmas.order.VisitingDate;
import java.util.HashMap;
import java.util.Map;

public class EventService {

    private static final int CHRISTMAS_DAY = 25;
    private Map<Event, Map<MenuCategory, Integer>> totalBenefit = new HashMap<>();

    public void applyDiscount(Order order) {
        OrderedMenus orderedMenus = order.getOrderedMenus();
        VisitingDate visitingDate = order.getVisitingDate();

        if (visitingDate.isInChristmasEventRange()) {
            int discountAmount = 900 + (CHRISTMAS_DAY - (visitingDate.getDDayUntilChristmas()) * 100);
            addBenefit(Event.CHRISTMAS_DISCOUNT, MenuCategory.TOTAL_ORDER_AMOUNT, discountAmount);
        }
    }

    private void addBenefit(Event event, MenuCategory menuCategory, Integer discountAmount) {
        Map<MenuCategory, Integer> discountTarget = new HashMap<>();
        discountTarget.put(menuCategory, discountAmount);

        totalBenefit.put(event, discountTarget);
    }
}