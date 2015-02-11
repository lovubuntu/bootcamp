package day2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MaxEmptySlotFinderTest {

    @Test
    public void shouldFindSlotWithMaxEmptySpace() {
        ParkingLot almostFullLot = mock(ParkingLot.class);
        ParkingLot almostEmptyLot = mock(ParkingLot.class);
        ParkingLot fullLot = mock(ParkingLot.class);

        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(almostEmptyLot);
        parkingLotList.add(almostFullLot);
        parkingLotList.add(fullLot);

        when(almostEmptyLot.getAvailableParkingSpace()).thenReturn(8);
        when(almostFullLot.getAvailableParkingSpace()).thenReturn(2);
        when(fullLot.getAvailableParkingSpace()).thenReturn(0);

        MaxEmptySlotFinder maxEmptySlotFinder = new MaxEmptySlotFinder();
        assertEquals(almostEmptyLot, maxEmptySlotFinder.findParkingLot(parkingLotList));
    }
}