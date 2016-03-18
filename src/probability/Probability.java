/*
job of CoinProbability-
    -should represent the probability of getting heads/tails of n number of coins.
 */


package probability;

public class Probability {
    private double probability;

    private Probability(double probability) {
        this.probability = probability;
    }

    public static Probability create(double probability) {
        if (probability > 1 || probability < 0)
            throw new IllegalArgumentException("Expected probability bellow 1 and greater than 0 but got " + probability);
        return new Probability(probability);
    }

    public Probability not() {
        return Probability.create(1 - this.probability);
    }


    public Probability and(Probability anotherProbability) {
        return create(this.probability * anotherProbability.probability);
    }

    public Probability or(Probability anotherProbability){
        Probability probabilityOfAnEventNotOccuring = this.not().and(anotherProbability.not());
        return probabilityOfAnEventNotOccuring.not();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Probability)) return false;

        Probability that = (Probability) o;

        return Double.compare(that.probability, probability) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(probability);
        return (int) (temp ^ (temp >>> 32));
    }
}
