package day2;

import org.junit.Test;

import static org.junit.Assert.*;

public class AttendantTest {

    @Test
    public void shouldAddNewSlotUnderAnAttendant() {
        Attendant attendant = new Attendant();
        assertTrue(attendant.addNewParkingLot(new ParkingLot(10, ParkingClass.DELUXE)));
    }

    @Test
    public void shouldFindSlotForAStandardCustomer() {
        Attendant attendant = new Attendant();
        attendant.addNewParkingLot(new ParkingLot(10, ParkingClass.DELUXE));
        attendant.addNewParkingLot(new ParkingLot(10, ParkingClass.PREMIUM));
        ParkingLot cheapParkingLot = new ParkingLot(10, ParkingClass.STANDARD);
        attendant.addNewParkingLot(cheapParkingLot);

        assertEquals(cheapParkingLot,attendant.findParkingLot());
    }

    @Test
    public void shouldFindParkingLotForCustomerWithPreference() {
        Attendant attendant = new Attendant();
        attendant.addNewParkingLot(new ParkingLot(8, ParkingClass.STANDARD));
        ParkingLot maxEmptyParkingLot = new ParkingLot(12, ParkingClass.PREMIUM);
        attendant.addNewParkingLot(maxEmptyParkingLot);

        assertEquals(maxEmptyParkingLot, attendant.findLotWithPreference(ParkingPreference.MAX_EMPTY_SLOT));
    }
}