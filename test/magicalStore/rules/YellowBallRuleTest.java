package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;
import magicalStore.Colors;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class YellowBallRuleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void isValidShouldApplyTheRuleOntheCurrentStateOfBallsAndReturnTrueForLessThan40PercentBallsAdded() throws Exception {
        YellowBallRule yellowBallRule = new YellowBallRule(0.4);
        Ball greenBall = new Ball(Colors.GREEN);
        Balls balls = new Balls();
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(greenBall);
        assertTrue(yellowBallRule.isValid(balls,greenBall));
    }
}