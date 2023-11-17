package christmas;

import static org.assertj.core.api.Assertions.*;

import christmas.event.Event;
import christmas.event.EventService;
import christmas.order.Order;
import christmas.order.OrderedMenus;
import christmas.order.VisitingDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventServiceTest {

    @DisplayName("방문날짜와 주문에 따른 주말할인, 크리스마스디데이할인 적용과 할인금액 계산 검증")
    @Test
    void applyDiscountAndCalculateTotalBenefit() {
        VisitingDate visitingDate = VisitingDate.from(15);

        OrderedMenus orderedMenus = OrderedMenus.of(List.of("티본스테이크", "해산물파스타", "초코케이크"));

        Order order = new Order(visitingDate, orderedMenus);

        EventService service = new EventService();

        service.applyDiscount(order);
        Map<Event, Integer> totalBenefit = service.getTotalBenefit();

        assertThat(totalBenefit).containsKeys(Event.CHRISTMAS_DISCOUNT, Event.WEEKEND_DISCOUNT);

        Integer christmasDiscountAmount = totalBenefit.get(Event.CHRISTMAS_DISCOUNT);
        Integer weekendDiscountAmount = totalBenefit.get(Event.WEEKEND_DISCOUNT);

        assertThat(christmasDiscountAmount).isEqualTo(2400);
        assertThat(weekendDiscountAmount).isEqualTo(4046);
    }
}
