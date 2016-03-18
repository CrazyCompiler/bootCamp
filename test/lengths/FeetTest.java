package lengths;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FeetTest {
    @Test
    public void compare_will_compare_feet_with_feets_and_provide_boolean_value() {
        Units feet = new Feet(2);
        Units feet1 = new Feet(2);
        assertTrue(feet.compare(feet1));
    }

    @Test
    public void compare_will_compare_centimeter_with_feets_and_provide_boolean_value() {
        Units centimeters = new Centimeter(60);
        Units feet = new Feet(2);
        assertTrue(feet.compare(centimeters));
    }
}