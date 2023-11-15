package christmas.order;

public class Order {
    private static final int EVENT_CRITERIA_TOTAL_PRICE = 10_000;
    private final VisitingDate visitingDate;
    private final OrderedMenus orderedMenus;

    public Order(VisitingDate visitingDate, OrderedMenus orderedMenus) {
        this.visitingDate = visitingDate;
        this.orderedMenus = orderedMenus;
    }

    public VisitingDate getVisitingDate() {
        return visitingDate;
    }

    public OrderedMenus getOrderedMenus() {
        return orderedMenus;
    }

    public boolean isTotalPriceOverEventCriteria() {
        return orderedMenus.getTotalPrice() >= EVENT_CRITERIA_TOTAL_PRICE;
    }
}