package measurements.exceptions;

public class NegativeMeasurementException extends Exception {
    public NegativeMeasurementException(double value) {
        super("Expected positive measurement but got "+value);
    }
}
