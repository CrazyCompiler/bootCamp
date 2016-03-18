package lengths;

public class Centimeter implements Units {

    private double centimeter;
    private double unitConstant = 30;

    public Centimeter(double centimeter) {
        this.centimeter = centimeter;
    }

    public double convertedIntoBaseUnit() {
        return this.centimeter/unitConstant;
    }

    @Override
    public boolean compare(Units unit) {
        return this.convertedIntoBaseUnit() == unit.convertedIntoBaseUnit();
    }
}
