package magicalStore.rules;

import magicalStore.Ball;
import magicalStore.Balls;

import java.util.ArrayList;

public class Rules {
    private ArrayList<Validators> rules = new ArrayList();

    public void add(Validators rule) {
        rules.add(rule);
    }

    public boolean isValid(Balls balls, Ball ball) throws Exception{
        for (Validators rule : this.rules) {
            rule.isValid(balls,ball);
        }
        return true;
    }
}
