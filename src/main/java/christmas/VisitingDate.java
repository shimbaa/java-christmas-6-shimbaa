package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitingDate {
    private static final int YEAR = 2023;
    private static final int DECEMBER = 12;

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
}