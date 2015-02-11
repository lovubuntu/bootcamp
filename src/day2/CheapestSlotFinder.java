package day2;

import java.util.List;

public class CheapestSlotFinder implements SlotFinder {
    @Override
    public ParkingLot findParkingLot(List<ParkingLot> availableParkingLots) {
        int lowParkingFare = Integer.MAX_VALUE;
        ParkingLot lowCostParkingLot = null;
        for (ParkingLot parkingLot : availableParkingLots) {
            if (parkingLot.getCost() < lowParkingFare && !parkingLot.isFull()) {
                lowParkingFare = parkingLot.getCost();
                lowCostParkingLot = parkingLot;
            }
        }
        return lowCostParkingLot;
    }
}
