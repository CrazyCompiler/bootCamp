package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;

public class RedBallRule implements Validators {
    private int getBallsCount(Balls balls,Colors color){
        int count = 0;
        for (Ball ball : balls) {
            if(ball.isOfColor(color))
                count++;
        }
        return count;
    }

    public boolean isValid(Balls balls, Ball ball) throws Exception{
        int greenBallsCount = getBallsCount(balls,Colors.GREEN);
        int redBallsCount = getBallsCount(balls,Colors.RED);

        if(ball.isOfColor(Colors.RED)) {
            redBallsCount++;
            if ((greenBallsCount * 2) <= redBallsCount)
                throw new ExceedsMaxRedBallsException();
        }
        return true;
    }
}
