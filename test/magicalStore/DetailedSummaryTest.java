package magicalStore;

import org.junit.Test;

import java.util.ArrayList;

public class DetailedSummaryTest {

    @Test
    public void getSummary() {
        ArrayList<Balls> bag = new ArrayList<>();
        bag.add(Balls.BLUE);
        bag.add(Balls.GREEN);
        bag.add(Balls.GREEN);
        bag.add(Balls.RED);
        bag.add(Balls.YELLOW);
        bag.add(Balls.YELLOW);
        bag.add(Balls.RED);
        bag.add(Balls.RED);
        bag.add(Balls.RED);
        bag.add(Balls.RED);

        DetailedSummary detailedSummary = new DetailedSummary(bag);
//        String expected = "Bag: 5 balls \n" +
//                "\n" +
//                "red : 1\n" +
//                "green : 2\n" +
//                "blue : 1\n" +
//                "yellow : 1\n";
//        assertEquals(expected, detailedSummary.getSummary());
    }
}
