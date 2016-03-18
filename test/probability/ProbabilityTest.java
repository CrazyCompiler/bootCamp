package probability;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityTest {
    @Test
    public void getRepresentation_provides_representation_of_getting_tails_when_a_coin_is_flipped() {
        Probability probability = new Probability(1);
        double expected = 0.5;
        double representation = probability.getEventRepresentation();
        assertEquals(expected,representation,0.0);
    }

    @Test
    public void getRepresentation_provides_representation_of_getting_heads_when_a_coin_is_flipped() {
        Probability probability = new Probability(1);
        double expected = 0.5;
        double representation = probability.getNotAnEventRepresentation();
        assertEquals(expected,representation,0.0);
    }

    @Test
    public void getRepresentation_provides_representation_of_getting_tails_when_more_than_one_coin_is_flipped() {
        Probability probability = new Probability(2);
        double expected = 0.5;
        double representation = probability.getEventRepresentation();
        assertEquals(expected,representation,0.0);
    }

    @Test
    public void getRepresentation_provides_representation_of_getting_atleast_one_tails_when_more_than_one_coin_is_flipped() {
        Probability probability = new Probability(2);
        double expected = 0.75;
        double representation = probability.getAtLeastOneEventRepresentation();
        assertEquals(expected,representation,0.0);
    }
}