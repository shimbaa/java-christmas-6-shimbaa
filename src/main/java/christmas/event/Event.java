package christmas.event;

public enum Event {
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인"),
    WEEKDAY_DISCOUNT("평일 할인"),
    WEEKEND_DISCOUNT("평일 할인"),
    SPECIAL_DISCOUNT("특별 할인"),
    GIVEAWAY_EVENT("증정 이벤트");

    private final String label;

    Event(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}