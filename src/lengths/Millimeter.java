package lengths;

public class Millimeter implements Units {

    private double millimeter;
    private double unitConstant = 300;

    public Millimeter(double millimeter) {
        this.millimeter = millimeter;
    }

    public double convertedIntoBaseUnit() {
        return this.millimeter / this.unitConstant;
    }

    @Override
    public boolean compare(Units unit) {
        return this.convertedIntoBaseUnit() == unit.convertedIntoBaseUnit();
    }
}
