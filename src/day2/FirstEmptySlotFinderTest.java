package day2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FirstEmptySlotFinderTest {

    @Test
    public void shouldGetFirstAvailableParkingLotWhenAllLotsAreAvailable() {
        List<ParkingLot> availableParkingLots = new ArrayList<ParkingLot>();
        ParkingLot firstParkingLot = new ParkingLot(10, ParkingClass.DELUXE);
        availableParkingLots.add(firstParkingLot);
        availableParkingLots.add(new ParkingLot(12, ParkingClass.PREMIUM));
        availableParkingLots.add(new ParkingLot(14, ParkingClass.STANDARD));

        FirstEmptySlotFinder firstEmptySlotFinder = new FirstEmptySlotFinder();

        assertEquals(firstParkingLot, firstEmptySlotFinder.findParkingLot(availableParkingLots));
    }

    @Test
    public void shouldGetFirstAvailableParkingLotWhenOnlySomeLotsAreAvailable() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot fullLot = new ParkingLot(1, ParkingClass.PREMIUM);
        ParkingLot firstAvailableParkingLot = new ParkingLot(2, ParkingClass.DELUXE);

        fullLot.allot(new Car());

        parkingLots.add(fullLot);
        parkingLots.add(firstAvailableParkingLot);
        parkingLots.add(new ParkingLot(14, ParkingClass.STANDARD));

        FirstEmptySlotFinder firstEmptySlotFinder = new FirstEmptySlotFinder();

        assertEquals(firstAvailableParkingLot, firstEmptySlotFinder.findParkingLot(parkingLots));
    }
}