package parkingAttendant;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldParkACarAndReturnNoOfFilledPlacesInParkingLot(){
        final Car car = new Car();
        final ParkingLot parkingLot = new ParkingLot(2);
        int totalNumberOfParkedCars = parkingLot.park(car);
        int expectedParkedCars = 1;
        assertEquals(expectedParkedCars,totalNumberOfParkedCars);
    }

    @Test
    public void shouldProvideTrueIfParkingLotIsFull(){
        final Car car = new Car();
        final ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);
        assertTrue(parkingLot.isFull());
    }

    @Test
    public void shouldProvideFalseIfParkingLotIsNotFull(){
        final Car car = new Car();
        final ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(car);
        assertFalse(parkingLot.isFull());
    }
}