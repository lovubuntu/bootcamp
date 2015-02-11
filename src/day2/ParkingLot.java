package day2;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private ParkingClass parkingClass;
    private CarCollection parkedCars;
    private ArrayList<ParkingLotListener> parkingLotListeners;
    private HashMap<CarCollection.Status, ArrayList<ParkingLotListener>> listeners;

    public ParkingLot(int capacity, ParkingClass parkingClass) {
        this.parkedCars = new CarCollection(capacity);
        listeners = new HashMap<CarCollection.Status, ArrayList<ParkingLotListener>>();
        this.parkingClass = parkingClass;

    }

    public boolean allot(Car carToPark) {
        if (parkedCars.isFull()) {
            return false;
        }

        parkedCars.add(carToPark);
        updateCarCollectionStatus();
        return true;
    }

    private void updateCarCollectionStatus() {
        if (parkedCars.isStatusChanged()) {
            notifyStatusChangeListeners();
        }
    }

    private void notifyStatusChangeListeners() {
        if (listeners.containsKey(parkedCars.getStatus()))
            for (ParkingLotListener listener : listeners.get(parkedCars.getStatus())) {
                listener.notifyStateChange();
            }
    }

    public boolean release(Car carToRelease) {
        if (parkedCars.contains(carToRelease)) {
            parkedCars.remove(carToRelease);
            updateCarCollectionStatus();
            return true;
        }
        return false;
    }

    public void addListener(ParkingLotListener parkingLotListener, CarCollection.Status interestedStatus) {
        if (listeners.containsKey(interestedStatus)) {
            listeners.get(interestedStatus).add(parkingLotListener);
        } else {
            ArrayList<ParkingLotListener> interestedListeners = new ArrayList<ParkingLotListener>();
            interestedListeners.add(parkingLotListener);
            listeners.put(interestedStatus, interestedListeners);
        }
    }

    public boolean isFull() {
        return parkedCars.isFull();
    }

    public int getCost() {
        return parkingClass.getCost();
    }

    public int getAvailableParkingSpace() {
        return parkedCars.getFreeSpace();
    }
}
