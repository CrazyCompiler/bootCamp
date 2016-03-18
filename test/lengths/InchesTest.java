package lengths;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InchesTest {
    @Test
    public void compare_will_compare_Inches_with_feets_and_provide_boolean_value() {
        Units inches = new Inches(24);
        Units feet = new Feet(2);
        assertTrue(inches.compare(feet));
    }

}