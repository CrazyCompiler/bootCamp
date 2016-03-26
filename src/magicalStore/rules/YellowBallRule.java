package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;

public class YellowBallRule implements Validators{

    private double percentage;

    public YellowBallRule(double percentage) {
        this.percentage = percentage;
    }

    public boolean isValid(Balls balls, Ball ball) throws Exception{
        if(ball.isOfColor(Colors.YELLOW)){
            double yellowBallPercentage = balls.getBallsCount(Colors.YELLOW) / balls.size();
            if(yellowBallPercentage<this.percentage)
                throw new ExceedsMaxYellowBallsException();
        }
        return true;
    }
}
