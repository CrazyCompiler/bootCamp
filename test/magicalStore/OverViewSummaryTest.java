package magicalStore;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OverViewSummaryTest {

    @Test
    public void getDesign() {
        ArrayList<Balls> bag= new ArrayList<>();
        bag.add(Balls.BLUE);
        bag.add(Balls.GREEN);
        bag.add(Balls.GREEN);
        bag.add(Balls.RED);
        bag.add(Balls.YELLOW);

        OverViewSummary overViewSummary = new OverViewSummary(bag);
        String expected = "Bag: 5 balls \n" +
                "\n" +
                "red : 1\n" +
                "green : 2\n" +
                "blue : 1\n" +
                "yellow : 1\n";
        assertEquals(expected, overViewSummary.getSummary());
    }
}