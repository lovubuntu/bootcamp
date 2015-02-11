package day2;

import day2.CarCollection.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Test
    public void shouldReturnCostForParking() {
        parkingLot = new ParkingLot(1, ParkingClass.DELUXE);
        assertEquals(ParkingClass.DELUXE.getCost(), parkingLot.getCost());
    }

    @Test
    public void shouldBeAbleToParkTheCar() {
        parkingLot = new ParkingLot(1, ParkingClass.DELUXE);
        Car car = new Car();
        assertTrue(parkingLot.allot(car));
    }

    @Test
    public void shouldBeAbleToTakeOutTheCar() {
        parkingLot = new ParkingLot(1, ParkingClass.DELUXE);
        Car car = new Car();
        parkingLot.allot(car);
        assertTrue(parkingLot.release(car));
    }

    @Test
    public void shouldReturnTrueWhenCapacityIsFull() {
        parkingLot = new ParkingLot(2, ParkingClass.DELUXE);
        parkCarsToLot(parkingLot,2);
        assertTrue(parkingLot.isFull());
    }

    private void parkCarsToLot(ParkingLot parkingLot, int carsCount) {

        for (int i = 0; i< carsCount; i++)
            parkingLot.allot(new Car());
    }

    @Test
    public void shouldNotifyConsumersWhenParkingLotIsFull() {
        parkingLot = new ParkingLot(1, ParkingClass.DELUXE);
        Car car1 = new Car();

        ParkingLotListener fullListener = mock(ParkingLotListener.class);
        parkingLot.addListener(fullListener, Status.FULL);

        parkingLot.allot(car1);
        verify(fullListener, times(1)).notifyStateChange();
    }

    @Test
    public void shouldNotifyConsumersWhenParkingLotIsAvailable() {
        parkingLot = new ParkingLot(2, ParkingClass.DELUXE);
        ParkingLotListener availableListener = mock(ParkingLotListener.class);

        parkingLot.addListener(availableListener,Status.FULL);
        Car car1 = new Car();
        parkingLot.allot(car1);

        Car car2 = new Car();
        parkingLot.allot(car2);

        ParkingLotListener newListener = mock(ParkingLotListener.class);
        parkingLot.addListener(newListener, Status.AVAILABLE);
        parkingLot.release(car1);
        verify(newListener, times(1)).notifyStateChange();
    }

    @Test
    public void shouldNotifyLotOwnerFillingStatus() {
        parkingLot = new ParkingLot(5, ParkingClass.DELUXE);
        ParkingLotListener fullListener = mock(ParkingLotListener.class);

        parkingLot.allot(new Car());
        parkingLot.allot(new Car());
        parkingLot.allot(new Car());
        parkingLot.allot(new Car());
        parkingLot.allot(new Car());

        verify(fullListener, times(1)).notifyStateChange();
    }

    @Test
    public void shouldReturnTheNumberOfSlotsEmpty() {
        parkingLot = new ParkingLot(5, ParkingClass.DELUXE);
        parkingLot.allot(new Car());

        assertEquals(4, parkingLot.getAvailableParkingSpace());
    }

}
