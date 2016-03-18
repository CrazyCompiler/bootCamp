package volumes;

import lengths.Units;

public class Volume {
    private Units unit;
    public Volume(Units unit) {
        this.unit = unit;
    }

    public boolean compare(Units anotherVolume) {
        return this.unit.convertedIntoBaseUnit() == anotherVolume.convertedIntoBaseUnit();
    }
}
