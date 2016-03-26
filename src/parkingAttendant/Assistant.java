package parkingAttendant;

import java.util.ArrayList;

public class Assistant implements ParkinglotObservers {
    ArrayList<ParkingLot> parkingLots = new ArrayList();

    @Override
    public void updateParkingSlots(Car car, int slotNumber, int parkingLotNumber) {
        parkingLots.get(parkingLotNumber).parkAtSlot(car,slotNumber);
    }

    @Override
    public void updateParkingLots(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
