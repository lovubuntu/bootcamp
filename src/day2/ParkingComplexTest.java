package day2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingComplexTest {
    private ParkingComplex parkingComplex;

    @Test
    public void shouldAddParkingLotToComplex() {
        parkingComplex = new ParkingComplex();
        assertTrue(parkingComplex.addParkingLot(new ParkingLot(10,ParkingClass.DELUXE)));
    }

    @Test
    public void shouldAddParkingLotToAttendee() {
        parkingComplex = new ParkingComplex();
        ParkingLot parkingLot = new ParkingLot(10, ParkingClass.DELUXE);
        parkingComplex.addParkingLot(parkingLot);
        ParkingComplex.Attendee attendee = new ParkingComplex.Attendee();
//        parkingComplex.addParkingLotToAttendee(parkingLot, attendee);
    }
}