package parkingAttendant;

public interface ParkinglotObservers {
    void updateParkingSlots(Car car, int slotNumber, int parkingLotNumber);
    void updateParkingLots(ParkingLot parkingLot);
}
