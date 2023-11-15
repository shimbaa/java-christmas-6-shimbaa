package christmas;

import christmas.order.VisitingDate;
import christmas.view.InputView;
import christmas.view.MenuInputForm;
import christmas.view.OutputView;
import java.util.List;

public class Controller {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {
        inputView.printHelloMessage();
        int visitingDateInput = inputView.getVisitingDate();

        VisitingDate visitingDate = VisitingDate.from(visitingDateInput);

        List<MenuInputForm> menuInputForms = inputView.getMenuAndQuantity();
        outputView.printOrderedMenu(menuInputForms);
    }
}