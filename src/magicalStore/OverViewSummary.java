package magicalStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class OverViewSummary implements SummaryDesigns{

    private ArrayList<Balls> bag;

    public OverViewSummary(ArrayList bag) {
        this.bag = bag;
    }

    private int getNumberOfBalls(String color){
        int size = 0;
        for (Balls ball:bag)
            if (ball.is(color))
                size++;
        return size;
    }

    public String getSummary() {
        HashMap ballCount = new HashMap();
        String summary = "Bag: "+bag.size()+" balls \n\n";

        for (Balls aBag : bag) {
            ballCount.put(aBag.getColor(),this.getNumberOfBalls(aBag.getColor()));
        }

        Iterator<String> keySetIterator = ballCount.keySet().iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            summary += key+" : "+ballCount.get(key)+"\n";
        }

        return summary;
    }
}
