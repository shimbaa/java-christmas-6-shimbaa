package christmas.menu;

public class MenuItem {
    private final String name;
    private final int price;
    private final MenuCategory menuCategory;

    public MenuItem(String name, int price, MenuCategory menuCategory) {
        this.name = name;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public boolean isDessert() {
        return menuCategory.equals(MenuCategory.DESSERT);
    }

    public boolean isMain() {
        return menuCategory.equals(MenuCategory.MAIN);
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }
}