package measurements;

import measurements.exceptions.IllegalOperationException;
import measurements.exceptions.NegativeMeasurementException;

public class Measurement {

    private double value;
    private Convertibles unit;

    private Measurement(double value, Convertibles unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Measurement create(double value, Convertibles unit) throws NegativeMeasurementException {
        if(value<0)
            throw new NegativeMeasurementException(value);
        return new Measurement(value,unit);
    }

    public boolean compare(Measurement comparableMeasurement) throws Exception {
        if(this.unit.getClass() != comparableMeasurement.unit.getClass())
            throw new IllegalOperationException("Two different measuring units cant be compared");
        double unitsInInches = Math.round(this.unit.convertIntoBaseUnit(this.value));
        double givenunitsInInches = Math.round(comparableMeasurement.unit.convertIntoBaseUnit(comparableMeasurement.value));
        return unitsInInches == givenunitsInInches;
    }


    public Measurement addLength(Measurement secondMeasurement) throws Exception {
        if(this.unit.getClass() != secondMeasurement.unit.getClass())
            throw new IllegalOperationException("My teacher is an idiot");
        double unitsInInches = this.unit.convertIntoBaseUnit(this.value);
        double givenunitsInInches = secondMeasurement.unit.convertIntoBaseUnit(secondMeasurement.value);
        double sum = unitsInInches + givenunitsInInches;
        return new Measurement(sum, LengthUnits.Inches);
    }

    public Measurement addVolumes(Measurement secondMeasurement) throws Exception {
        if(this.unit.getClass() != secondMeasurement.unit.getClass())
            throw new IllegalOperationException("My teacher is an idiot");
        double unitsInLiters = this.unit.convertIntoBaseUnit(this.value);
        double givenunitsInLiters = secondMeasurement.unit.convertIntoBaseUnit(secondMeasurement.value);
        double sum = unitsInLiters + givenunitsInLiters;
        return new Measurement(sum, VolumeUnits.Liters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Measurement)) return false;

        Measurement that = (Measurement) o;

        if (Double.compare(that.value, value) != 0) return false;
        return unit == that.unit;
    }

}
