package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;

public class GreenBallRule implements Validators {
    private int max;

    public GreenBallRule(int max) {
        this.max = max;
    }


    public boolean isValid(Balls balls, Ball ball) throws Exception {
        if ((balls.size() >= this.max) && (ball.isOfColor(Colors.GREEN)))
            throw new ExceedsMaxGreenBallsException();
        return true;
    }
}
