package christmas.event;

public enum EventBadge {
    STAR("별", 5_000, 10_000),
    TREE("트리", 10_000, 20_000),
    SANTA("산타", 20_000, Integer.MAX_VALUE),
    NONE("없음", 0, 0);

    private final String label;
    private final int minAmount;
    private final int maxAmount;

    EventBadge(String label, int minAmount, int maxAmount) {
        this.label = label;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public static EventBadge of(int totalBenefitAmount) {
        for (EventBadge badge : EventBadge.values()) {
            if (totalBenefitAmount >= badge.minAmount && totalBenefitAmount < badge.maxAmount) {
                return badge;
            }
        }
        return NONE;
    }

    public String getLabel() {
        return label;
    }
}
