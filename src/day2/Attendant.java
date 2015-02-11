package day2;

import java.util.ArrayList;
import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;
    private SlotFinder slotFinder;
    public Attendant() {
        parkingLots = new ArrayList<ParkingLot>();
        slotFinder = new CheapestSlotFinder();
    }

    public boolean addNewParkingLot(ParkingLot parkingLot) {
        return parkingLots.add(parkingLot);
    }

    public ParkingLot findParkingLot() {
        return slotFinder.findParkingLot(parkingLots);
    }

    public ParkingLot findLotWithPreference(ParkingPreference preference) {
        if (preference == ParkingPreference.MAX_EMPTY_SLOT)
            return new MaxEmptySlotFinder().findParkingLot(parkingLots);
        else if (preference == ParkingPreference.FIND_FIRST)
            return new FirstEmptySlotFinder().findParkingLot(parkingLots);
        else if (preference == ParkingPreference.CHEAPEST_LOT) {
            return new CheapestSlotFinder().findParkingLot(parkingLots);
        }
        return null;
    }
}
