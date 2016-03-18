package volumes;

import lengths.Units;

public class Liters implements Units {

    private double liters;
    private double unitConstant = 3.78;

    public Liters(double liters) {
        this.liters = liters;
    }

    public double convertedIntoBaseUnit() {
        return liters / unitConstant;
    }

    @Override
    public boolean compare(Units unit) {
        return this.convertedIntoBaseUnit() == unit.convertedIntoBaseUnit();
    }
}