/*
job of FlipCoin-
    -flip a coin calculates the probability of tails out single flip and given a coin .
 */


package probability;

public class ChanceRepresentor {

    private int favourableCondition = 1;
    private int sampleSpace = 2;



    public String getRepresentation() {
        return favourableCondition+"/"+sampleSpace;
    }
}
