package magicalStore;

import java.util.ArrayList;

public class Balls {

    private final ArrayList<Ball> balls = new ArrayList<Ball>();

    public int size() {
        return balls.size();
    }

    public boolean add(Ball ball) {
        return balls.add(ball);
    }

    public int getBallsCount(Colors color){
        int count = 0;
        for (Ball ball : this.balls)
            if (ball.isOfColor(color))
                count++;
        return count;
    }
}
