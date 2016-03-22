
/*
    Job:- It holds the balls according to the laws.

 */

package magicalStore;

import java.util.ArrayList;

public class Bag {

    private final int maxValue;
    private ArrayList<Balls> balls = new ArrayList<>();

    public Bag(int maxValue) {
        this.maxValue = maxValue;
    }

    public int currentBagSizeIs() {
        return balls.size();
    }

    private int getNumberOfBalls(String color) {
        int size = 0;
        for (Balls ball : balls)
            if (ball.is(color))
                size++;
        return size;
    }

    private void checkForMaxBalls() throws Exception {
        if (balls.size() >= maxValue)
            throw new BagOutOfStorageException();
    }

    private void checkForMaxGreenBalls() throws Exception {
        int maxGreenBalls = 3;
        if (getNumberOfBalls("green") >= maxGreenBalls)
            throw new ExceedsMaxGreenBallsException();
    }

    private void checkForMaxRedBalls() throws Exception {
        if (getNumberOfBalls("green") == 0)
            throw new ExceedsMaxRedBallsException();
        if (getNumberOfBalls("red") > 0)
            if (2 * getNumberOfBalls("green") > getNumberOfBalls("red"))
                throw new ExceedsMaxRedBallsException();
    }

    private void checkForMaxYellowBalls() throws Exception {
        if (balls.size()<3)
            throw new ExceedsMaxYellowBallsException();
        if (balls.size() > 0) {
            double yellowBallPercentage = getNumberOfBalls("yellow") / this.balls.size() * 100;
            if (yellowBallPercentage > 40)
                throw new ExceedsMaxYellowBallsException();
        }
    }

    public void add(Balls ball) throws Exception {
        checkForMaxBalls();
        if (ball.is("green"))
            checkForMaxGreenBalls();
        if (ball.is("red"))
            checkForMaxRedBalls();
        if (ball.is("yellow"))
            checkForMaxYellowBalls();
        balls.add(ball);
    }

    public String getSummary(){
        SummaryDesigns design = new OverViewSummary(balls);
        return design.getSummary();
    }
}
