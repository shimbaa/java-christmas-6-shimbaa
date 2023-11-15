package christmas.order;

public record Order(VisitingDate visitingDate, OrderedMenus orderedMenus) {
    private static final int EVENT_CRITERIA_TOTAL_PRICE = 10_000;

    public boolean isTotalPriceOverEventCriteria() {
        return orderedMenus.getTotalPrice() >= EVENT_CRITERIA_TOTAL_PRICE;
    }
}