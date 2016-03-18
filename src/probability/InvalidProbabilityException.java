package probability;

public class InvalidProbabilityException extends Exception{
    public InvalidProbabilityException(double probability) {
        super("Expected probability below 1 and greater than 0 but got "+probability);
    }
}
