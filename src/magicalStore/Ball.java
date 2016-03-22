package magicalStore;

public class Ball {
    private String color;

    public Ball(String color) {
        this.color = color;
    }

    public boolean is(String color) {
        return color.equals(this.color);
    }
}
