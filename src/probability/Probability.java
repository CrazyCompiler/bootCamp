/*
job of CoinProbability-
    -should represent the probability of getting heads/tails of n number of coins.
 */


package probability;

public class Probability {
    private int noOfCoins;
    private double singleCoinFavourableOutcome = 1;
    private double singleCoinSampleSpace = 2;

    public Probability(int noOfCoins) {
        this.noOfCoins = noOfCoins;
    }

    private double calculateSampleSpace() {
        return noOfCoins*singleCoinSampleSpace;
    }
    private double calculateFavourableOutcome() {
        return noOfCoins*singleCoinFavourableOutcome;
    }

    public double getEventRepresentation() {
        double favourableOutcome = calculateFavourableOutcome();
        double sampleSpace = calculateSampleSpace();
        return favourableOutcome/sampleSpace;
    }

    public double getAtLeastOneEventRepresentation() {
        System.out.println(1-((1- getEventRepresentation())*(1- getEventRepresentation())) * 2);
        return 1-((1- getEventRepresentation())*(1- getEventRepresentation()));
    }

    public double getNotAnEventRepresentation() {
        return 1- getEventRepresentation();
    }
}
