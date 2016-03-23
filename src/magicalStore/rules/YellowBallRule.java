package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;

public class YellowBallRule implements Validators{

    private double percentage;

    public YellowBallRule(double percentage) {
        this.percentage = percentage;
    }

    private int getBallsCount(Balls balls,Colors color){
        int count = 0;
        for (Ball ball : balls) {
            if(ball.isOfColor(color))
                count++;
        }
        return count;
    }

    public boolean isValid(Balls balls, Ball ball) throws Exception{
        if(ball.isOfColor(Colors.YELLOW)){
            double yellowBallPercentage = getBallsCount(balls,Colors.YELLOW) / balls.size();
            if(yellowBallPercentage<this.percentage)
                throw new ExceedsMaxYellowBallsException();
        }
        return true;
    }
}
