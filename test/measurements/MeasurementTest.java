package measurements;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MeasurementTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void compare_12_inches_1_feets_returns_true() throws NegativeMeasurementException {
        Units inches = Units.Inches;
        Units feet = Units.Feet;
        Measurement firstMeasurement = Measurement.create(12,inches);
        Measurement secondMeasurement = Measurement.create(1,feet);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_feets_12_inches_feets_returns_true() throws NegativeMeasurementException {
        Units inches = Units.Inches;
        Units feet = Units.Feet;
        Measurement firstMeasurement = Measurement.create (1,feet);
        Measurement secondMeasurement = Measurement.create (12,inches);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_2_inches_5_cm_feets_returns_true() throws NegativeMeasurementException {
        Units inches = Units.Inches;
        Units centimeter = Units.Centimeter;
        Measurement firstMeasurement = Measurement.create (5,centimeter);
        Measurement secondMeasurement = Measurement.create(2,inches);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_cm_10_mm_feets_returns_true() throws NegativeMeasurementException {
        Units cm = Units.Centimeter;
        Units mm = Units.Millimeter;
        Measurement firstMeasurement = Measurement.create(1,cm);
        Measurement secondMeasurement = Measurement.create(10,mm);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_gallon_with_liters() throws NegativeMeasurementException {
        Units gallons = Units.Gallons;
        Units liters = Units.Liters;
        Measurement firstMeasurement = Measurement.create(1,gallons);
        Measurement secondMeasurement = Measurement.create(3.78,liters);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void add_inches_returns_result_sum_in_inches() throws NegativeMeasurementException {
        Units inches = Units.Inches;
        Measurement firstMeasurement = Measurement.create(2,inches);
        Measurement secondMeasurement = Measurement.create(2,inches);
        Measurement expecteMeasurement = Measurement.create(4,inches);
        assertEquals(expecteMeasurement,firstMeasurement.add(secondMeasurement));
    }

    @Test
    public void add_any_two_units_and_returns_result_sum_in_inches() throws NegativeMeasurementException {
        Units inches = Units.Inches;
        Units cm = Units.Centimeter;
        Measurement firstMeasurement = Measurement.create(2,inches);
        Measurement secondMeasurement = Measurement.create(2,cm);
        Measurement expectedMeasurement = Measurement.create(3.0,inches);
        assertEquals(expectedMeasurement,firstMeasurement.add(secondMeasurement));
    }

    @Test
    public void createMeasurement_throw_error_if_negative_value_is_provided() throws NegativeMeasurementException {
        Units cm = Units.Centimeter;
        thrown.expect(NegativeMeasurementException.class);
        thrown.expectMessage("Expected positive measurement but got -20.0");
        Measurement.create(-20,cm);
    }
}