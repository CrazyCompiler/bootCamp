package measurements;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MeasurementTest {

    @Test
    public void compare_12_inches_1_feets_returns_true() {
        Units inches = Units.Inches;
        Units feet = Units.Feet;
        Measurement firstMeasurement = new Measurement(12,inches);
        Measurement secondMeasurement = new Measurement(1,feet);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_feets_12_inches_feets_returns_true() {
        Units inches = Units.Inches;
        Units feet = Units.Feet;
        Measurement firstMeasurement = new Measurement(1,feet);
        Measurement secondMeasurement = new Measurement(12,inches);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_2_inches_5_cm_feets_returns_true() {
        Units inches = Units.Inches;
        Units centimeter = Units.Centimeter;
        Measurement firstMeasurement = new Measurement(5,centimeter);
        Measurement secondMeasurement = new Measurement(2,inches);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_cm_10_mm_feets_returns_true() {
        Units cm = Units.Centimeter;
        Units mm = Units.Millimeter;
        Measurement firstMeasurement = new Measurement(1,cm);
        Measurement secondMeasurement = new Measurement(10,mm);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_gallon_with_liters() {
        Units gallons = Units.Gallons;
        Units liters = Units.Liters;
        Measurement firstMeasurement = new Measurement(1,gallons);
        Measurement secondMeasurement = new Measurement(3.78,liters);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void add_inches_returns_result_sum_in_inches() {
        Units inches = Units.Inches;
        Measurement firstMeasurement = new Measurement(2,inches);
        Measurement secondMeasurement = new Measurement(2,inches);
        Measurement expecteMeasurement = new Measurement(4,inches);
        assertEquals(expecteMeasurement,firstMeasurement.add(secondMeasurement));
    }

    @Test
    public void add_any_two_units_and_returns_result_sum_in_inches() {
        Units inches = Units.Inches;
        Units cm = Units.Centimeter;
        Measurement firstMeasurement = new Measurement(2,inches);
        Measurement secondMeasurement = new Measurement(2,cm);
        Measurement expecteMeasurement = new Measurement(3.0,inches);
        assertEquals(expecteMeasurement,firstMeasurement.add(secondMeasurement));
    }
}