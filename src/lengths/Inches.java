package lengths;

public class Inches implements Units {

    private double inches;
    private double unitConstant = 12;

    public Inches(double inches) {
        this.inches = inches;
    }

    public double convertedIntoBaseUnit(){
        return inches/unitConstant;
    }

    @Override
    public boolean compare(Units unit) {
        return this.convertedIntoBaseUnit() == unit.convertedIntoBaseUnit();
    }

}
