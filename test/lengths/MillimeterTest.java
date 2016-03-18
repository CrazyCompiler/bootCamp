package lengths;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MillimeterTest {

    @Test
    public void compare_will_compare_centimeter_with_millimeter_and_provide_boolean_value() {
        Units centimeters = new Centimeter(60);
        Units millimeter = new Millimeter(600);
        assertTrue(millimeter.compare(centimeters));
    }

}