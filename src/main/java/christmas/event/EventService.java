package christmas.event;

import christmas.order.Order;
import christmas.order.OrderedMenus;
import christmas.order.VisitingDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EventService {

    private static final int CHRISTMAS_DAY = 25;
    private static final int PRESENT_EVENT_CRITERIA = 120_000;
    private static final int CHAMPAGNE_PRICE = 25_000;
    private static final int BASE_CHRISTMAS_DISCOUNT = 900;
    private static final int PER_DAY_CHRISTMAS_DISCOUNT = 100;
    private static final int DISCOUNT_PER_MENU = 2_023;
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;
    private final Map<Event, Integer> totalBenefit = new HashMap<>();

    public void applyDiscount(Order order) {
        if (order.isTotalPriceOverEventCriteria()) {
            OrderedMenus orderedMenus = order.orderedMenus();
            VisitingDate visitingDate = order.visitingDate();

            applyDiscount(orderedMenus, visitingDate);
        }
    }

    private void applyDiscount(OrderedMenus orderedMenus, VisitingDate visitingDate) {
        applyChristMasDiscount(visitingDate);
        applyWeekDayDiscount(orderedMenus, visitingDate);
        applyWeekEndDiscount(orderedMenus, visitingDate);
        applySpecialDiscount(visitingDate);
        applyPresentEvent(orderedMenus);
    }

    public void applyPresentEvent(OrderedMenus orderedMenus) {
        if (orderedMenus.getTotalPrice() >= PRESENT_EVENT_CRITERIA) {
            totalBenefit.put(Event.PRESENT_EVENT, CHAMPAGNE_PRICE);
        }
    }

    private void applyChristMasDiscount(VisitingDate visitingDate) {
        if (visitingDate.isInChristmasEventRange()) {
            int discountAmount = calculateChristmasDiscount(visitingDate);
            totalBenefit.put(Event.CHRISTMAS_DISCOUNT, discountAmount);
        }
    }

    private int calculateChristmasDiscount(VisitingDate visitingDate) {
        return BASE_CHRISTMAS_DISCOUNT +
                ((CHRISTMAS_DAY - (visitingDate.getDDayUntilChristmas())) * PER_DAY_CHRISTMAS_DISCOUNT);
    }

    private void applyWeekDayDiscount(OrderedMenus orderedMenus, VisitingDate visitingDate) {
        if (orderedMenus.countDessertMenu() != 0 && visitingDate.isWeekDayEventRange()) {
            int dessertMenuCount = orderedMenus.countDessertMenu();
            int discountAmount = calculateDiscount(dessertMenuCount);
            totalBenefit.put(Event.WEEKDAY_DISCOUNT, discountAmount);
        }
    }

    private void applyWeekEndDiscount(OrderedMenus orderedMenus, VisitingDate visitingDate) {
        if (orderedMenus.countMainMenu() != 0 && visitingDate.isWeekendEventRange()) {
            int mainMenuCount = orderedMenus.countMainMenu();
            int discountAmount = calculateDiscount(mainMenuCount);
            totalBenefit.put(Event.WEEKEND_DISCOUNT, discountAmount);
        }
    }

    private int calculateDiscount(int menuCount) {
        return menuCount * DISCOUNT_PER_MENU;
    }

    private void applySpecialDiscount(VisitingDate visitingDate) {
        if (visitingDate.isSpecialEventRange()) {
            totalBenefit.put(Event.SPECIAL_DISCOUNT, SPECIAL_DISCOUNT_AMOUNT);
        }
    }

    public Map<Event, Integer> getTotalBenefit() {
        return Collections.unmodifiableMap(totalBenefit);
    }

    public int getTotalBenefitAmount() {
        return totalBenefit.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getTotalDiscountAmount() {
        return totalBenefit.keySet().stream()
                .filter(key -> !key.equals(Event.PRESENT_EVENT))
                .map(totalBenefit::get)
                .mapToInt(Integer::intValue)
                .sum();
    }
}