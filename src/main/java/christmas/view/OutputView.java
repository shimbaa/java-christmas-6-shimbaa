package christmas.view;

import christmas.VisitingDateDTO;
import christmas.event.Event;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");


    public void printBenefitMessage(VisitingDateDTO visitingDateDTO) {
        int dayOfMonth = visitingDateDTO.getDayOfMonth();
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", dayOfMonth);
        System.out.println();
    }

    public void printOrderedMenu(List<MenuInputForm> menuInputForms) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        menuInputForms.forEach(menuInputForm ->
                System.out.printf("%s %d개\n", menuInputForm.getMenuName(), menuInputForm.getMenuQuantity()));
    }

    public void printTotalOrderPriceBeforeDiscount(int totalPrice) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(getDecimalFormat(totalPrice) + "원");
    }

    public void printPresentEvent(Map<Event, Integer> totalBenefit) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        Integer benefit = totalBenefit.getOrDefault(Event.PRESENT_EVENT, 0);
        if (benefit == 0) {
            System.out.println("없음");
        }
        if (benefit != 0) {
            System.out.println("샴페인 1개");
        }
    }

    public void printBenefitDetails(Map<Event, Integer> totalBenefit) {
        System.out.println();
        System.out.println("<혜택 내역>");

        totalBenefit.forEach((event, discount) -> {
            if (discount != 0) {
                System.out.println(formatDiscount(event, discount));
            }
        });
    }

    private String formatDiscount(Event event, int discount) {
        String label = event.getLabel();
        String formattedDiscount = getDecimalFormat(-discount) + "원";
        return String.format("%s: %s", label, formattedDiscount);
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(getDecimalFormat(-totalBenefitAmount) + "원");
    }

    private String getDecimalFormat(int number) {
        return DECIMAL_FORMAT.format(number);
    }
}