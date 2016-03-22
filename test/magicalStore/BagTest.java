package magicalStore;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BagTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addBallAddsBallToBag() throws Exception {
        Bag bag = new Bag(12);
        bag.add(Balls.BLUE);
        int expected = 1;
        assertEquals(expected, bag.currentBagSizeIs());
    }

    @Test
    public void addBallThrowsExceptionForMorethan12Balls() throws Exception {
        Bag bag = new Bag(0);
        thrown.expect(BagOutOfStorageException.class);
            bag.add(Balls.BLUE);
    }

    @Test
    public void addBallToMagicalBagThrowsExceptionForMoreThan3GreenBallsAdded() throws Exception {
        Bag bag = new Bag(12);
        thrown.expect(ExceedsMaxGreenBallsException.class);
        for (int i = 0; i <= 4; i++) {
            bag.add(Balls.GREEN);
        }
    }

    @Test
    public void addBallToBagThrowsExceptionForRedColorIsAddedBeforeGreenColor() throws Exception {
        Bag bag = new Bag(12);
        thrown.expect(ExceedsMaxRedBallsException.class);
        bag.add(Balls.RED);
    }

    @Test
    public void addBallToBagThrowsExceptionForRedColorMoreThanTheDoubleOFGreenBallsAdded() throws Exception {
        Bag bag = new Bag(12);
        Balls greenBall = Balls.GREEN;
        Balls redBall = Balls.RED;
        thrown.expect(ExceedsMaxRedBallsException.class);
        bag.add(greenBall);
        bag.add(redBall);
        bag.add(redBall);
    }

    @Test
    public void addBallToBagThrowsExceptionForYellowColorMoreThanFourtyPercentOfTotalBalls() throws Exception {
        Bag bag = new Bag(12);
        Balls greenBall = Balls.GREEN;
        Balls redBlue = Balls.BLUE;
        Balls yellowBall = Balls.YELLOW;
        thrown.expect(ExceedsMaxYellowBallsException.class);
        bag.add(greenBall);
        bag.add(redBlue);
        bag.add(yellowBall);
    }


    @Test
    public void getSummaryGivesOverviewSummaryOfTheBag() throws Exception {
        Bag bag = new Bag(12);
        bag.add(Balls.BLUE);
        bag.add(Balls.GREEN);
        bag.add(Balls.GREEN);
        bag.add(Balls.RED);
        bag.add(Balls.YELLOW);
        String expected = "Bag: 5 balls \n" +
                "\n" +
                "red : 1\n" +
                "green : 2\n" +
                "blue : 1\n" +
                "yellow : 1\n";
        assertEquals(expected, bag.getSummary());
    }
}