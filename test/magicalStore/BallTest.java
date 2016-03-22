package magicalStore;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BallTest {
    @Test
    public void ballTellsIfItIsOfDifferentColor() {
        Ball ball = new Ball("green");
        assertTrue(ball.is("green"));
    }
}