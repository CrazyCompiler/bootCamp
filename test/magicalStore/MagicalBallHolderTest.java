package magicalStore;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MagicalBallHolderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addBallToTheBagGivesCurrentSizeOfBag() throws Exception {
        MagicalBallHolder magicalBallHolder = new MagicalBallHolder(12);
        Ball ball = new Ball("green");
        magicalBallHolder.add(ball);
        int expected = 1;
        assertEquals(expected, magicalBallHolder.currentBagSizeIs());
    }

    @Test
    public void addBallToTheMagicalBagThrowsExceptionForMorethan12Balls() throws Exception {
        MagicalBallHolder magicalBallHolder = new MagicalBallHolder(12);
        Ball ball = new Ball("blue");
        thrown.expect(Exception.class);
        thrown.expectMessage("Exceed maximum size of bag");
        for (int i = 0; i <= 12; i++) {
            magicalBallHolder.add(ball);
        }
    }

    @Test
    public void addBallToMagicalBagThrowsExceptionForMoreThan3GreenBallsAdded() throws Exception {
        MagicalBallHolder magicalBallHolder = new MagicalBallHolder(12);
        Ball ball = new Ball("green");
        thrown.expect(Exception.class);
        thrown.expectMessage("Exceed maximum number of green balls in a bag");
        for (int i = 0; i <= 4; i++) {
            magicalBallHolder.add(ball);
        }
    }

    @Test
    public void addBallToMagicalBagThrowsExceptionForRedColorIsAddedBeforeGreenColor() throws Exception {
        MagicalBallHolder magicalBallHolder = new MagicalBallHolder(12);
        Ball greenBall = new Ball("green");
        Ball redBall = new Ball("red");
        thrown.expect(Exception.class);
        thrown.expectMessage("Exceed maximum number of red balls in a bag");
        magicalBallHolder.add(redBall);
    }

    @Test
    public void addBallToMagicalBagThrowsExceptionForRedColorMoreThanTheDoubleOFGreenBallsAdded() throws Exception {
        MagicalBallHolder magicalBallHolder = new MagicalBallHolder(12);
        Ball greenBall = new Ball("green");
        Ball redBall = new Ball("red");
        thrown.expect(Exception.class);
        thrown.expectMessage("Exceed maximum number of red balls in a bag");
        magicalBallHolder.add(greenBall);
        magicalBallHolder.add(redBall);
        magicalBallHolder.add(redBall);
    }

}