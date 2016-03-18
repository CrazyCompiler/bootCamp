package probability;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ProbabilityTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void create_throws_illegalArgumentError_if_number_greater_than_1_is_provided()  {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected probability bellow 1 and greater than 0 but got 2.0");
        Probability probability = Probability.create(2.0);
    }

    @Test
    public void create_throws_illegalArgumentError_if_number_smaller_than_0_is_provided()  {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected probability bellow 1 and greater than 0 but got -12.0");
        Probability probability = Probability.create(-12.0);
    }

    @Test
    public void not_provides_probablity_of_any_event_not_occuring() {
        Probability probability = Probability.create(0.5);
        Probability probabilityNotOccuring = Probability.create(0.5);
        assertEquals(probabilityNotOccuring,probability.not());
    }

    @Test
    public void atleastOneEvent_provides_probability_of_any_event_occuring_atleast_once() throws Exception {
        Probability probability = Probability.create(0.5);
        Probability probabilityOfNotOccuring = Probability.create(0.5);
        Probability expected = Probability.create(0.75);
        assertEquals(expected,probability.or(probabilityOfNotOccuring));

    }
}