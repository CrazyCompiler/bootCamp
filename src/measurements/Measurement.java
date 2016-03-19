package measurements;

public class Measurement {

    private double value;
    private Units unit;

    private Measurement(double value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Measurement create(double value, Units unit) throws NegativeMeasurementException {
        if(value<0)
            throw new NegativeMeasurementException(value);
        return new Measurement(value,unit);
    }

    public boolean compare(Measurement comparableMeasurement) {
        double unitsInInches = Math.round(this.unit.convertIntoBaseUnit(this.value));
        double givenunitsInInches = Math.round(comparableMeasurement.unit.convertIntoBaseUnit(comparableMeasurement.value));
        return unitsInInches == givenunitsInInches;
    }


    public Measurement add(Measurement secondMeasurement) {
        double unitsInInches = this.unit.convertIntoBaseUnit(this.value);
        double givenunitsInInches = secondMeasurement.unit.convertIntoBaseUnit(secondMeasurement.value);
        double sum = unitsInInches + givenunitsInInches;
        return new Measurement(Math.round(sum), Units.Inches);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Measurement)) return false;

        Measurement that = (Measurement) o;

        if (Double.compare(that.value, value) != 0) return false;
        return unit == that.unit;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
