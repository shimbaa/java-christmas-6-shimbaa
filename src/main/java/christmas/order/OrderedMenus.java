package christmas.order;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import java.util.List;

public class OrderedMenus {
    private final List<MenuItem> menuItems;

    public static OrderedMenus of(List<String> menuItemInputs) {
        Menu menu = new Menu();
        List<MenuItem> menuItems = menuItemInputs.stream()
                .map(menu::getMenuItem)
                .toList();

        return new OrderedMenus(menuItems);
    }

    private OrderedMenus(List<MenuItem> menuItems) {
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

    public int getTotalPrice() {
        return menuItems.stream()
                .mapToInt(MenuItem::getPrice)
                .sum();
    }
}