package magicalStore;

import java.util.ArrayList;

public class DetailedSummary implements SummaryDesigns {

    private ArrayList<Balls> bag;

    public DetailedSummary(ArrayList bag) {
        this.bag = bag;
    }

    public String getSummary() {
        String summary = "Bag: "+bag.size()+" balls \n\n";
        int count = 1;
        String previousBallColor="";

        for (Balls ball : bag) {
            if(ball.is(previousBallColor))
                count++;
            else {
                    summary += count + previousBallColor.substring(0) + ", ";
                    previousBallColor = ball.getColor();
                    count = 1;
            }
        }

        return summary;
    }
}
