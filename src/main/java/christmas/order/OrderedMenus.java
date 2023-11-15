package christmas.order;

import christmas.menu.Menu;
import christmas.menu.MenuCategory;
import christmas.menu.MenuItem;
import java.util.List;
import java.util.Optional;

public class OrderedMenus {
    private static final String ONLY_BEVERAGE = "[ERROR] 음료만 주문 시, 주문할 수 없습니다.";
    private final List<MenuItem> menuItems;

    public static OrderedMenus of(List<String> menuItemInputs) {
        Menu menu = new Menu();
        List<MenuItem> menuItems = menuItemInputs.stream()
                .map(menu::getMenuItem)
                .toList();

        return new OrderedMenus(menuItems);
    }

    private OrderedMenus(List<MenuItem> menuItems) {
        validateIsBeverageOnly(menuItems);
        this.menuItems = menuItems;
    }

    private void validateIsBeverageOnly(List<MenuItem> menuItems) {
        if (isOnlyBeverage(menuItems)) {
            throw new IllegalArgumentException(ONLY_BEVERAGE);
        }
    }

    private boolean isOnlyBeverage(List<MenuItem> menuItems) {
        Optional<MenuItem> notBeverageMenu = menuItems.stream()
                .filter(menuItem -> !menuItem.getMenuCategory().equals(MenuCategory.BEVERAGE))
                .findAny();

        return notBeverageMenu.isEmpty();
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