package lengths;

public class Feet implements Units {

    private double feet;
    private double unitConstant = 1;

    public Feet(double feet) {
        this.feet = feet;
    }

    public double convertedIntoBaseUnit() {
        return feet/unitConstant;
    }

    @Override
    public boolean compare(Units unit) {
        return this.convertedIntoBaseUnit() == unit.convertedIntoBaseUnit();
    }
}
