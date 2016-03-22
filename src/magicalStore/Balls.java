package magicalStore;

public enum Balls {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    YELLOW("yellow");

    private String color;

    Balls(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean is(String color) {
        return color.equals(this.color);
    }
}
