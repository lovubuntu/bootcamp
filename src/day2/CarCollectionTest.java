package day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarCollectionTest {

    private CarCollection carCollection;

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowUserToCreateLotWithZeroCapacity() {
        carCollection = new CarCollection(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowUserToCreateLotWithNegativeCapacity() {
        carCollection = new CarCollection(-10);
    }

    @Test
    public void shouldTestCollectionFull() {
        carCollection = new CarCollection(2);

        carCollection.add(new Car());
        carCollection.add(new Car());
        assertTrue(carCollection.isFull());
    }

    @Test
    public void shouldUpdateStatusChangedOnTransitionToNewState() {
        carCollection = new CarCollection(5);
        assertEquals(CarCollection.Status.AVAILABLE, carCollection.getStatus());
        carCollection.add(new Car());
        carCollection.add(new Car());
        carCollection.add(new Car());
        carCollection.add(new Car());

        assertEquals(CarCollection.Status.LIMITED_AVAILABILITY, carCollection.getStatus());
        assertTrue(carCollection.isStatusChanged());
    }

    @Test
    public void shouldUpdateStatusWhenCollectionFull() {
        carCollection = new CarCollection(1);

        carCollection.add(new Car());
        assertEquals(CarCollection.Status.FULL, carCollection.getStatus());
    }

    @Test
    public void shouldUpdateStatusWhenCollectionAvailable() {
        carCollection = new CarCollection(5);

        assertEquals(CarCollection.Status.AVAILABLE, carCollection.getStatus());
    }

    @Test
    public void shouldUpdateStatusWhenOnlyLimitedSlotsAvailable() {
        carCollection = new CarCollection(5);
        carCollection.add(new Car());
        carCollection.add(new Car());
        carCollection.add(new Car());
        carCollection.add(new Car());

        assertEquals(CarCollection.Status.LIMITED_AVAILABILITY, carCollection.getStatus());
    }

    @Test
    public void shouldReturnTheAvailableCapacity() {
        carCollection = new CarCollection(5);
        carCollection.add(new Car());
        assertEquals(4, carCollection.getFreeSpace());
    }
}