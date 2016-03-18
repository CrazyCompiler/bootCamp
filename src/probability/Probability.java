/*
job of Probability-
    -should represent the probability of getting heads/tails of n number of coins.
 */


package probability;

public class Probability {
    private double probability;

    private Probability(double probability) {
        this.probability = probability;
    }

    public static Probability create(double probability) throws InvalidProbabilityException {
        if (probability > 1 || probability < 0)
            throw new InvalidProbabilityException(probability);
        return new Probability(probability);
    }

    public Probability not() throws InvalidProbabilityException {
        return Probability.create(1 - this.probability);
    }


    public Probability and(Probability anotherProbability) throws InvalidProbabilityException {
        return create(this.probability * anotherProbability.probability);
    }

    public Probability or(Probability anotherProbability) throws InvalidProbabilityException {
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
