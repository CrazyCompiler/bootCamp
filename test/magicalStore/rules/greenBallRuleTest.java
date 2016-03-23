package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class GreenBallRuleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void isValidShouldApplyTheRuleOntheCurrentStateOfBallsAndReturnTrueForLessThanThreeBallsAdded() throws Exception {
        GreenBallRule greenBallRule = new GreenBallRule(3);
        Ball greenBall = new Ball(Colors.GREEN);
        Balls balls = new Balls();
        balls.add(greenBall);
        assertTrue(greenBallRule.isValid(balls,greenBall));
    }

    @Test
    public void isValidShouldApplyTheRuleOntheCurrentStateOfBallsAndThrowExceptionForMoreThanThreeBallsAdded() throws Exception {
        GreenBallRule greenBallRule = new GreenBallRule(3);
        Ball greenBall = new Ball(Colors.GREEN);
        Balls balls = new Balls();
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(greenBall);
        thrown.expect(ExceedsMaxGreenBallsException.class);
        greenBallRule.isValid(balls,greenBall);
    }

}