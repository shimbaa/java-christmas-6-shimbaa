package christmas.order;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitingDate {
    private static final int YEAR = 2023;
    private static final int DECEMBER = 12;
    private static final int CHRISTMAS_DAY = 25;

    private final int dayOfMonth;

    public static VisitingDate from(int dayOfMonth) {
        return new VisitingDate(dayOfMonth);
    }

    private VisitingDate(int dayOfMonth) {
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
}