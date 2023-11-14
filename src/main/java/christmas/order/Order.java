package christmas.order;

public class Order {
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
}