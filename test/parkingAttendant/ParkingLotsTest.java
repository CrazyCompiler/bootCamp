package parkingAttendant;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParkingLotsTest {
    @Test
    public void shouldIncludeAParkingLotToTheParkingLotsReturnNumberOfParkingLots() {
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(5);
        ArrayList<ParkinglotObservers> observers= new ArrayList<>();
        final ParkingLots parkingLots = new ParkingLots(observers);
        int noOfParkingLots = parkingLots.add(firstParkingLot);
        noOfParkingLots = parkingLots.add(secondParkingLot);
        assertEquals(2,noOfParkingLots);
    }

    @Test
    public void shouldParkACarAndReturnTheSizeOfFilledParkingSlots() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(5);
        ArrayList<ParkinglotObservers> observers= new ArrayList<>();
        final ParkingLots parkingLots = new ParkingLots(observers);
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        int totalFilledSlots = parkingLots.park(car);
        assertEquals(1,totalFilledSlots);
    }

}