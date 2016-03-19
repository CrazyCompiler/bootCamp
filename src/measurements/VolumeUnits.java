package measurements;

public enum VolumeUnits implements  Measurables{
    Gallons(VolumeUnits.litersToGallons),
    Liters(VolumeUnits.litersToLiters);

    private static final double litersToGallons = 0.264172;
    private static final double litersToLiters = 1;

    public double unitConstant;


    VolumeUnits(double unitConstant) {
        this.unitConstant = unitConstant;
    }

    public double convertIntoBaseUnit(Double value){
        return value/unitConstant;
    }
}
