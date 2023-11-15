package christmas.order;

import christmas.VisitingDateDTO;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitingDate {
    private static final int YEAR = 2023;
    private static final int DECEMBER = 12;
    private static final int CHRISTMAS_DAY = 25;
    private static final String INVALID_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final int dayOfMonth;

    public static VisitingDate from(int dayOfMonth) {
        return new VisitingDate(dayOfMonth);
    }

    private VisitingDate(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 31) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
        this.dayOfMonth = dayOfMonth;
    }

    public DayOfWeek getDayOfWeek() {
        LocalDate date = LocalDate.of(YEAR, DECEMBER, dayOfMonth);
        return date.getDayOfWeek();
    }

    public boolean isInChristmasEventRange() {
        return dayOfMonth <= CHRISTMAS_DAY;
    }

    public int getDDayUntilChristmas() {
        return CHRISTMAS_DAY - dayOfMonth;
    }

    public boolean isWeekDayEventRange() {
        return !isWeekendEventRange();
    }

    public boolean isWeekendEventRange() {
        DayOfWeek dayOfWeek = getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    public boolean isSpecialEventRange() {
        DayOfWeek dayOfWeek = getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.SUNDAY) || dayOfMonth == CHRISTMAS_DAY;
    }

    public VisitingDateDTO getVisitingDateDTO() {
        return VisitingDateDTO.from(dayOfMonth);
    }
}