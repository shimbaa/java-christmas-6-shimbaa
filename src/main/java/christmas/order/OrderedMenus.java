package christmas.order;

import christmas.menu.MenuItem;
import java.util.List;

public class OrderedMenus {
    private final List<MenuItem> menuItems;

    public OrderedMenus(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}