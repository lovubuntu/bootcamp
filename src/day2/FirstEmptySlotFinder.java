package day2;

import java.util.List;

public class FirstEmptySlotFinder implements SlotFinder{
    @Override
    public ParkingLot findParkingLot(List<ParkingLot> availableParkingLots) {
        for (ParkingLot parkingLot : availableParkingLots) {
            if (!parkingLot.isFull())
                return parkingLot;
        }
        return null;
    }
}
