package measurements;

import measurements.exceptions.IllegalOperationException;
import measurements.exceptions.NegativeMeasurementException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MeasurementTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void compare_12_inches_1_feets_returns_true() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Convertibles feet = LengthUnits.Feet;
        Measurement firstMeasurement = Measurement.create(12,inches);
        Measurement secondMeasurement = Measurement.create(1,feet);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_feets_12_inches_feets_returns_true() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Convertibles feet = LengthUnits.Feet;
        Measurement firstMeasurement = Measurement.create (1,feet);
        Measurement secondMeasurement = Measurement.create (12,inches);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_2_inches_5_cm_feets_returns_true() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Convertibles centimeter = LengthUnits.Centimeter;
        Measurement firstMeasurement = Measurement.create (5,centimeter);
        Measurement secondMeasurement = Measurement.create(2,inches);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_cm_10_mm_feets_returns_true() throws Exception {
        Convertibles cm = LengthUnits.Centimeter;
        Convertibles mm = LengthUnits.Millimeter;
        Measurement firstMeasurement = Measurement.create(1,cm);
        Measurement secondMeasurement = Measurement.create(10,mm);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void compare_1_gallon_with_1_liters() throws Exception {
        Convertibles gallons = VolumeUnits.Gallons;
        Convertibles liters = VolumeUnits.Liters;
        Measurement firstMeasurement = Measurement.create(1,gallons);
        Measurement secondMeasurement = Measurement.create(3.78,liters);
        assertTrue(firstMeasurement.compare(secondMeasurement));
    }

    @Test
    public void add_inches_returns_result_sum_in_inches() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Measurement firstMeasurement = Measurement.create(2,inches);
        Measurement secondMeasurement = Measurement.create(2,inches);
        Measurement expecteMeasurement = Measurement.create(4,inches);
        assertEquals(expecteMeasurement,firstMeasurement.addLength(secondMeasurement));
    }

    @Test
    public void add_any_two_Lengths_and_returns_result_sum_in_inches() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Convertibles cm = LengthUnits.Centimeter;
        Measurement firstMeasurement = Measurement.create(2,inches);
        Measurement secondMeasurement = Measurement.create(2,cm);
        Measurement expectedMeasurement = Measurement.create(2.7874015748031495,inches);
        assertEquals(expectedMeasurement,firstMeasurement.addLength(secondMeasurement));
    }

    @Test
    public void createMeasurement_throw_error_if_negative_value_is_provided() throws NegativeMeasurementException {
        Convertibles cm = LengthUnits.Centimeter;
        thrown.expect(NegativeMeasurementException.class);
        thrown.expectMessage("Expected positive measurement but got -20.0");
        Measurement.create(-20,cm);
    }

    @Test
    public void compare_1_gallon_to_1_inch() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Convertibles gallons = VolumeUnits.Gallons;
        Measurement firstMeasurement = Measurement.create(1,inches);
        Measurement secondMeasurement = Measurement.create(1,gallons);
        thrown.expect(IllegalOperationException.class);
        thrown.expectMessage("Two different measuring units cant be compared");
        firstMeasurement.compare(secondMeasurement);
    }

    @Test
    public void add_any_volumes_will_give_sum_of_volumes_in_liters() throws Exception {
        Convertibles liters = VolumeUnits.Liters;
        Convertibles gallons = VolumeUnits.Gallons;
        Measurement firstMeasurement = Measurement.create(1,liters);
        Measurement secondMeasurement = Measurement.create(1,gallons);
        Measurement expectedMeasurement = Measurement.create(4.785412534257983,liters);
        assertEquals(expectedMeasurement,firstMeasurement.addVolumes(secondMeasurement));
    }

    @Test
    public void adding_volume_unit_with_length_unit_throws_exception() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Convertibles gallons = VolumeUnits.Gallons;
        Measurement firstMeasurement = Measurement.create(2,inches);
        Measurement secondMeasurement = Measurement.create(2,gallons);
        thrown.expect(IllegalOperationException.class);
        thrown.expectMessage("My teacher is an idiot");
        firstMeasurement.addLength(secondMeasurement);
    }

    @Test
    public void adding_length_unit_with_volume_unit_throws_exception() throws Exception {
        Convertibles inches = LengthUnits.Inches;
        Convertibles gallons = VolumeUnits.Gallons;
        Measurement firstMeasurement = Measurement.create(2,inches);
        Measurement secondMeasurement = Measurement.create(2,gallons);
        thrown.expect(IllegalOperationException.class);
        thrown.expectMessage("My teacher is an idiot");
        secondMeasurement.addVolumes(firstMeasurement);
    }

}