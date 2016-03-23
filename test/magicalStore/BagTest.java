package magicalStore;

import magicalStore.rules.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class BagTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addBallToTheBagReturnsCurrentSizeOfBallAfterAddingBall() throws Exception {
        Ball blueBall = new Ball(Colors.BLUE);
        Rules rules = new Rules();
        Bag bag = new Bag(12,rules);
        int size = bag.add(blueBall);
        assertEquals(1,size);
    }

    @Test
    public void addBallShouldThrowMaxBagFullExceptionIfTheBagIsFullAndSomeoneTriesToAddMoreBall() throws Exception {
        Ball blueBall = new Ball(Colors.BLUE);
        Rules rules = new Rules();
        Bag bag = new Bag(0,rules);
        thrown.expect(BagFullException.class);
        bag.add(blueBall);
    }

    @Test
    public void addBallsShouldNotAllowMoreThanThreeGreenBallsToAdded() throws Exception {
        Ball greenBall = new Ball(Colors.GREEN);
        Rules rules = new Rules();
        Validators greenBallRule = new GreenBallRule(3);
        rules.add(greenBallRule);
        Bag bag = new Bag(12,rules);
        thrown.expect(ExceedsMaxGreenBallsException.class);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
        bag.add(greenBall);
    }

    @Test
    public void addBallsShouldNotAllowMoreRedBallsThanDoubleOfGreenBalls() throws Exception {
        Ball redBall = new Ball(Colors.RED);
        Rules rules = new Rules();
        Validators redBallRule = new RedBallRule();
        rules.add(redBallRule);
        Bag bag = new Bag(12,rules);
        thrown.expect(ExceedsMaxRedBallsException.class);
        bag.add(redBall);
    }

    @Test
    public void addBallsShouldNotAllowToAddYellowBallsMoreThan40PercentOfTotalBalls() throws Exception {
        Ball blueBall = new Ball(Colors.BLUE);
        Ball yellowBall = new Ball(Colors.YELLOW);
        Rules rules = new Rules();
        Validators yellowBallRule = new YellowBallRule(0.4);
        rules.add(yellowBallRule);
        Bag bag = new Bag(5,rules);
        thrown.expect(ExceedsMaxYellowBallsException.class);
        bag.add(blueBall);
        bag.add(yellowBall);
    }


}