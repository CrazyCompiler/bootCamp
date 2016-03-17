package probability;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceRepresentorTest {

    ChanceRepresentor chanceRepresentor;

    @Before
    public void setUp() throws Exception {
        chanceRepresentor = new ChanceRepresentor();
    }

    @Test
    public void getRepresentation_provides_representation_of_getting_tails_when_a_coin_is_flipped() {
        String expected = "1/2";
        String representation = chanceRepresentor.getRepresentation();
        assertEquals(expected,representation);
    }
}