package christmas.view;

public class MenuInputForm {
    private final String menuName;
    private final int menuQuantity;

    public static MenuInputForm of(String menuName, int menuQuantity) {
        return new MenuInputForm(menuName, menuQuantity);
    }

    private MenuInputForm(String menuName, int menuQuantity) {
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuQuantity() {
        return menuQuantity;
    }
}