package ParkingSystem;

public interface Parkable {
    Ticket parkVehicle(ParkingLot parkingLot, String licensePlate);
    void retrieveVehicle(ParkingLot parkingLot, int ticketNumber);
}
