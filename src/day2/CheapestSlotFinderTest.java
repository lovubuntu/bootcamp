package day2;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class CheapestSlotFinderTest {

    @Test
    public void shouldFindCheapestLotFromAvailableLots() {
        CheapestSlotFinder slotFinder = new CheapestSlotFinder();
        ArrayList<ParkingLot> availableParkingLots = new ArrayList<ParkingLot>();
        availableParkingLots.add(new ParkingLot(10, ParkingClass.DELUXE));
        availableParkingLots.add(new ParkingLot(10, ParkingClass.PREMIUM));
        availableParkingLots.add(new ParkingLot(10, ParkingClass.STANDARD));
        assertEquals(ParkingClass.STANDARD.getCost(), slotFinder.findParkingLot(availableParkingLots).getCost());
    }
}