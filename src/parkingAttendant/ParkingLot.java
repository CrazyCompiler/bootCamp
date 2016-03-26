/*
    Job of parkingLot
       should park a car.
 */

package parkingAttendant;

import java.util.ArrayList;


public class ParkingLot {

    private int size;
    private ArrayList<Car> cars = new ArrayList();
//    private ArrayList<ParkingLotEventNotifiers> events = new ArrayList<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public int park(Car car) {
        cars.add(car);
        return cars.size();
    }

    public boolean isFull() {
        return size == cars.size();
    }

    public int filledSpaces() {
        return cars.size();
    }

    public int getSlotNumber(Car car) {
        return cars.indexOf(car);
    }

    public void parkAtSlot(Car car, int slotNumber) {
        cars.add(slotNumber, car);
    }

}
