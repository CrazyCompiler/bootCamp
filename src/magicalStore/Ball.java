package magicalStore;

public class Ball {

    private Colors color;

    public Ball(Colors color) {
        this.color = color;
    }

    public boolean isOfColor(Colors color) {
        return this.color.equals(color);
    }
}
