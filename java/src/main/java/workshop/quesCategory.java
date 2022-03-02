package workshop;

public enum quesCategory {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");

    private final String label;

    quesCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
