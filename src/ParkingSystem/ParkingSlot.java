package ParkingSystem;

public class ParkingSlot {
    private int slotNumber;
    private Vehicle parkedCar;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return parkedCar != null;
    }

    public void parkCar(Vehicle vehicle) {
        this.parkedCar = vehicle;
    }

    public void removeCar() {
        this.parkedCar = null;
    }

    public Vehicle getParkedCar() {
        return parkedCar;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
