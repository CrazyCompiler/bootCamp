package magicalStore;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BallTest {
    @Test
    public void ballTellsIfItIsOfDifferentColor() {
        Balls ball = Balls.GREEN;
        assertTrue(ball.is("green"));
    }
}