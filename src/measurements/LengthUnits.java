package measurements;

public enum LengthUnits implements  Measurables{

    Feet(LengthUnits.inchesToFeets),
    Inches(LengthUnits.inchesToInches),
    Millimeter(LengthUnits.inchesToMillimeter),
    Centimeter(LengthUnits.inchesToCentimeter),
    Gallon(LengthUnits.inchesToGallons);

    private static final double inchesToFeets = 0.0833333;
    private static final double inchesToInches = 1;
    private static final double inchesToMillimeter = 25.4;
    private static final double inchesToCentimeter = 2.54;
    private static final double inchesToGallons = 1;



    private double unitConstant;

    LengthUnits(double unitConstant) {
        this.unitConstant = unitConstant;
    }

    public double convertIntoBaseUnit(Double value){
        return value/unitConstant;
    }
}
