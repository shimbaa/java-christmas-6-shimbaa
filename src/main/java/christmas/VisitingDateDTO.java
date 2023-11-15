package christmas;

public class VisitingDateDTO {

    private final int dayOfMonth;

    public static VisitingDateDTO from(int dayOfMonth) {
        return new VisitingDateDTO(dayOfMonth);
    }

    private VisitingDateDTO(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }
}