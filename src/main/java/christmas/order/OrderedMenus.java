package christmas.order;

import christmas.menu.MenuItem;
import java.util.List;

public class OrderedMenus {
    private final List<MenuItem> menuItems;

    public OrderedMenus(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int countDessertMenu() {
        return (int) menuItems.stream()
                .filter(MenuItem::isDessert)
                .count();
    }

    public int countMainMenu() {
        return (int) menuItems.stream()
                .filter(MenuItem::isMain)
                .count();
    }
}