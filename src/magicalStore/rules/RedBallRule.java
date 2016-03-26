package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;

public class RedBallRule implements Validators {

    public boolean isValid(Balls balls, Ball ball) throws Exception{
        int greenBallsCount = balls.getBallsCount(Colors.GREEN);
        int redBallsCount = balls.getBallsCount(Colors.RED);

        if(ball.isOfColor(Colors.RED)) {
            redBallsCount++;
            if ((greenBallsCount * 2) <= redBallsCount)
                throw new ExceedsMaxRedBallsException();
        }
        return true;
    }
}
