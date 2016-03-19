package measurements;

public enum Units {

    Feet(Units.inchesToFeets),
    Inches(Units.inchesToInches),
    Millimeter(Units.inchesToMillimeter),
    Centimeter(Units.inchesToCentimeter),
    Gallons(Units.gallonToGallons),
    Liters(Units.gallonToLiters);

    private static final double inchesToFeets = 0.0833333;
    private static final double inchesToInches = 1;
    private static final double inchesToMillimeter = 25.4;
    private static final double inchesToCentimeter = 2.54;

    private static final double gallonToLiters = 3.78;
    private static final double gallonToGallons = 1;


    private double unitConstant;

    Units(double unitConstant) {
        this.unitConstant = unitConstant;
    }

    public double convertIntoBaseUnit(Double value){
        return value/unitConstant;
    }

}
