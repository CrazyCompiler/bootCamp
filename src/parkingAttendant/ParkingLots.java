package parkingAttendant;

import java.util.ArrayList;

public class ParkingLots {
    ArrayList<ParkingLot> parkingLots = new ArrayList();
    ArrayList<ParkinglotObservers> observers;

    public ParkingLots(ArrayList<ParkinglotObservers> observers) {
        this.observers = observers;
    }

    public int add(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        for (ParkinglotObservers observer : observers) {
            observer.updateParkingLots(parkingLot);
        }
        return parkingLots.size();
    }

    private int totalFilledSpaces(){
        int totalFilledSize = 0;
        for (ParkingLot parkingLot : parkingLots) {
            totalFilledSize += parkingLot.filledSpaces();
        }
        return totalFilledSize;
    }

    public int park(Car car) {
        int parkingLotNumber = 0;
        int slotNumber = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if(!(parkingLot.isFull())){
                parkingLotNumber = parkingLots.indexOf(parkingLot);
                slotNumber = parkingLot.getSlotNumber(car);
                parkingLot.park(car);
                break;
            }
        }

        for (ParkinglotObservers observer : observers) {
            observer.updateParkingSlots(car,slotNumber,parkingLotNumber);
        }

        return totalFilledSpaces();
    }
}
