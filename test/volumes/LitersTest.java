package volumes;

import lengths.Units;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LitersTest {

    @Test
    public void compare_will_compare_liters_with_gallons_and_provide_boolean_value() {
        Units liters = new Liters(3.78);
        Units gallon = new Gallons(1);
        assertTrue(liters.compare(gallon));
    }
}