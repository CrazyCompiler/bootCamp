package magicalStore;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BallTest {

    @Test
    public void isOfColorShouldCheckIfTheBallIsOfSameGivenColor() {
        Ball ball = new Ball(Colors.BLUE);
        assertTrue(ball.isOfColor(Colors.BLUE));
    }
}