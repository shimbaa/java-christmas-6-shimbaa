package christmas.menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static Map<String, MenuItem> menuItems;

    public Menu() {
        menuItems = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        addItem("양송이수프", 6_000, MenuCategory.APPETIZER);
        addItem("타파스", 5_500, MenuCategory.APPETIZER);
        addItem("시저샐러드", 8_000, MenuCategory.APPETIZER);
        addItem("티본스테이크", 55_000, MenuCategory.MAIN);
        addItem("바비큐립", 54_000, MenuCategory.MAIN);
        addItem("해산물파스타", 35_000, MenuCategory.MAIN);
        addItem("크리스마스파스타", 25_000, MenuCategory.MAIN);
        addItem("초코케이크", 15_000, MenuCategory.DESSERT);
        addItem("아이스크림", 5_000, MenuCategory.DESSERT);
        addItem("제로콜라", 3_000, MenuCategory.BEVERAGE);
        addItem("레드와인", 60_000, MenuCategory.BEVERAGE);
        addItem("샴페인", 25_000, MenuCategory.BEVERAGE);
    }

    private void addItem(String name, int price, MenuCategory category) {
        menuItems.put(name, new MenuItem(name, price, category));
    }

    public MenuItem getMenuItem(String name) {
        validateNameExists(name);
        return menuItems.get(name);
    }

    private void validateNameExists(String name) {
        if (menuItems.get(name) == null) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}