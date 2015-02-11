package day2;

import java.util.List;

public class MaxEmptySlotFinder implements SlotFinder{
    @Override
    public ParkingLot findParkingLot(List<ParkingLot> availableParkingLots) {
        int maxEmptySlotCount = 0;
        ParkingLot maxEmptyParkingLot = null;
        for (ParkingLot parkingLot: availableParkingLots) {
            if (maxEmptySlotCount < parkingLot.getAvailableParkingSpace()) {
                maxEmptyParkingLot = parkingLot;
                maxEmptySlotCount = parkingLot.getAvailableParkingSpace();
            }
        }
        return maxEmptyParkingLot;
    }
}
