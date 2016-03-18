package lengths;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CentimeterTest {
    @Test
    public void compare_will_compare_millimetre_with_centimeter_and_provide_boolean_value() {
        Units millimeter = new Millimeter(10);
        Units centimeter = new Centimeter(1);
        assertTrue(millimeter.compare(centimeter));
    }
}