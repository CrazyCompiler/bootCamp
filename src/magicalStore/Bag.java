package magicalStore;

import magicalStore.rules.Rules;

public class Bag {
    private int size;
    private Balls balls = new Balls();
    private Rules rules;

    public Bag(int size, Rules rules) {
        this.size = size;
        this.rules = rules;
    }

    public int add(Ball ball) throws Exception{
        if(this.balls.size()>=this.size)
            throw new BagFullException();
        rules.isValid(this.balls,ball);
        this.balls.add(ball);
        return this.balls.size();
    }
}
