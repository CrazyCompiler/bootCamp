package magicalStore;


import java.util.ArrayList;

public class MagicalBallHolder {

    private final int  maxValue;
    private ArrayList<Ball> balls = new ArrayList<Ball>();

    public MagicalBallHolder(int maxValue) {
        this.maxValue = maxValue;
    }


    public int currentBagSizeIs() {
        return balls.size();
    }

    private int checkNumberOfBalls(String color){
        int size = 0;
        for (Ball ball:balls) {
            if(ball.is(color))
                size++;
        }
        return size;
    }

    private void checkForMaxBalls() throws Exception {
        if(balls.size()>=maxValue)
            throw new Exception("Exceed maximum size of bag");
    }

    private void checkForMaxGreenBalls() throws Exception {
        int maxGreenBalls = 3;
        if(checkNumberOfBalls("green") > maxGreenBalls)
            throw new Exception("Exceed maximum number of green balls in a bag");
    }

    private void checkForMaxRedBalls(Ball ball) throws Exception {
        if(checkNumberOfBalls("green")==0 && ball.is("red"))
            throw new Exception("Exceed maximum number of red balls in a bag");
        if(checkNumberOfBalls("red")>0 )
            if(2*checkNumberOfBalls("green") > checkNumberOfBalls("red"))
                throw new Exception("Exceed maximum number of red balls in a bag");
    }

    public void add(Ball ball) throws Exception {
        checkForMaxBalls();
        checkForMaxGreenBalls();
        checkForMaxRedBalls(ball);
        balls.add(ball);
    }
}
