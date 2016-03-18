package volumes;

import lengths.Units;

public class Gallons implements Units {

    private double gallons;
    private double unitConstant = 1;

    public Gallons(double gallons) {
        this.gallons = gallons;
    }

    public double convertedIntoBaseUnit() {
        return gallons / unitConstant;
    }

    @Override
    public boolean compare(Units unit) {
        return this.convertedIntoBaseUnit() == unit.convertedIntoBaseUnit();
    }
}
