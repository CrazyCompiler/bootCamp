package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class RedBallRuleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void isValidShouldApplyTheRuleOntheCurrentStateOfBallsAndReturnTrueForLessThanDoubleOfGreenBallsAreAdded() throws Exception {
        RedBallRule redBallRule = new RedBallRule();
        Ball greenBall = new Ball(Colors.GREEN);
        Ball redBall = new Ball(Colors.RED);
        Balls balls = new Balls();
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(greenBall);
        assertTrue(redBallRule.isValid(balls,redBall));
    }

    @Test
    public void isValidShouldApplyTheRuleOntheCurrentStateOfBallsAndThrowsExceptionForMoreThanDoubleOfGreenBallsAreAdded() throws Exception {
        RedBallRule redBallRule = new RedBallRule();
        Ball greenBall = new Ball(Colors.GREEN);
        Ball redBall = new Ball(Colors.RED);
        Balls balls = new Balls();
        balls.add(greenBall);
        balls.add(redBall);
        thrown.expect(ExceedsMaxRedBallsException.class);
        redBallRule.isValid(balls,redBall);
    }

    @Test
    public void isValidShouldApplyTheRuleOntheCurrentStateOfBallsAndThrowsExceptionIfRedBallIsAddedBeforeGreenBalls() throws Exception {
        RedBallRule redBallRule = new RedBallRule();
        Ball greenBall = new Ball(Colors.GREEN);
        Ball redBall = new Ball(Colors.RED);
        Balls balls = new Balls();
        balls.add(redBall);
        thrown.expect(ExceedsMaxRedBallsException.class);
        redBallRule.isValid(balls,redBall);
    }
}