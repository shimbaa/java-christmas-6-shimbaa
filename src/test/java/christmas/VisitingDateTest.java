package christmas;

import static org.assertj.core.api.Assertions.*;

import christmas.order.VisitingDate;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VisitingDateTest {

    @DisplayName("날짜를 입력하면 해당 날짜의 요일을 판단한다")
    @ParameterizedTest
    @MethodSource("provideMapForgetDayOfWeekFromDayOfMonth")
    void getDayOfWeekFromDayOfMonth_Monday(Map<Integer, DayOfWeek> map) {
        List<Integer> dayOfMonthValues = map.keySet().stream().toList();
        List<DayOfWeek> dayOfWeekValues = map.values().stream().toList();

        for (int i = 0; i < dayOfMonthValues.size(); i++) {
            Integer dayOfMonthValue = dayOfMonthValues.get(i);

            VisitingDate date = VisitingDate.from(dayOfMonthValue);
            DayOfWeek dayOfWeekTarget = date.getDayOfWeek();

            assertThat(dayOfWeekTarget).isEqualTo(dayOfWeekValues.get(i));
        }
    }

    private static Stream<Arguments> provideMapForgetDayOfWeekFromDayOfMonth() {
        return Stream.of(
                Arguments.of(Map.of(4, DayOfWeek.MONDAY)),
                Arguments.of(Map.of(5, DayOfWeek.TUESDAY)),
                Arguments.of(Map.of(6, DayOfWeek.WEDNESDAY)),
                Arguments.of(Map.of(7, DayOfWeek.THURSDAY)),
                Arguments.of(Map.of(8, DayOfWeek.FRIDAY)),
                Arguments.of(Map.of(9, DayOfWeek.SATURDAY)),
                Arguments.of(Map.of(10, DayOfWeek.SUNDAY))

        );
    }
}