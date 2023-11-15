package christmas.view;

import christmas.order.VisitingDateDTO;
import christmas.event.Event;
import christmas.event.EventBadge;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");
    private static final String BENEFIT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDERED_MENU_TITLE = "<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_DISCOUNT_TITLE = "<할인 전 총주문 금액>";
    private static final String PRESENT_EVENT_TITLE = "<증정 메뉴>";
    private static final String NONE = "없음";
    private static final String EA = "개";
    private static final String PRESENT_CONTENT = "샴페인 1" + EA;
    private static final String BENEFIT_DETAILS_TITLE = "<혜택 내역>";
    private static final String KOR_WON = "원";
    private static final String TOTAL_BENEFIT_AMOUNT_TITLE = "<총혜택 금액>";
    private static final String TOTAL_PRICE_AFTER_DISCOUNT_TITLE = "<할인 후 예상 결제 금액>";
    private static final String DECEMBER_EVENT_BADGE_TITLE = "<12월 이벤트 배지>";


    public void printBenefitMessage(VisitingDateDTO visitingDateDTO) {
        int dayOfMonth = visitingDateDTO.getDayOfMonth();
        System.out.printf(BENEFIT_PREVIEW_MESSAGE, dayOfMonth);
        System.out.println();
    }

    public void printOrderedMenu(List<MenuInputForm> menuInputForms) {
        System.out.println();
        System.out.println(ORDERED_MENU_TITLE);
        menuInputForms.forEach(menuInputForm ->
                System.out.printf("%s %d" + EA + "\n", menuInputForm.getMenuName(), menuInputForm.getMenuQuantity()));
    }

    public void printTotalOrderPriceBeforeDiscount(int totalPrice) {
        System.out.println();
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT_TITLE);
        System.out.println(getDecimalFormat(totalPrice) + KOR_WON);
    }

    public void printPresentEvent(Map<Event, Integer> totalBenefit) {
        System.out.println();
        System.out.println(PRESENT_EVENT_TITLE);
        Integer benefit = totalBenefit.getOrDefault(Event.PRESENT_EVENT, 0);
        if (benefit == 0) {
            System.out.println(NONE);
        }
        if (benefit != 0) {
            System.out.println(PRESENT_CONTENT);
        }
    }

    public void printBenefitDetails(Map<Event, Integer> totalBenefit) {
        System.out.println();
        System.out.println(BENEFIT_DETAILS_TITLE);
        if (totalBenefit.isEmpty()) {
            System.out.println(NONE);
        }
        if (!totalBenefit.isEmpty()) {
            totalBenefit.forEach(this::printExistingBenefit);
        }
    }

    private void printExistingBenefit(Event event, Integer discount) {
        if (discount != 0) {
            System.out.println(formatDiscount(event, discount));
        }
    }

    private String formatDiscount(Event event, int discount) {
        String label = event.getLabel();
        String formattedDiscount = getDecimalFormat(-discount) + KOR_WON;
        return String.format("%s: %s", label, formattedDiscount);
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println();
        System.out.println(TOTAL_BENEFIT_AMOUNT_TITLE);
        System.out.println(getDecimalFormat(-totalBenefitAmount) + KOR_WON);
    }

    public void printTotalOrderPriceAfterDiscount(int totalPriceAfterDiscount) {
        System.out.println();
        System.out.println(TOTAL_PRICE_AFTER_DISCOUNT_TITLE);
        System.out.println(getDecimalFormat(totalPriceAfterDiscount) + KOR_WON);
    }

    public void printEventBadge(EventBadge eventBadge) {
        System.out.println();
        System.out.println(DECEMBER_EVENT_BADGE_TITLE);
        System.out.println(eventBadge.getLabel());
    }

    private String getDecimalFormat(int number) {
        return DECIMAL_FORMAT.format(number);
    }
}