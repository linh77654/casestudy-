package ParkingSystem;

public class Ticket {
    private static int ticketCounter = 0;
    private int ticketNumber;
    private Vehicle vehicle;

    public Ticket(Vehicle vehicle) {
        this.ticketNumber = ++ticketCounter;
        this.vehicle = vehicle;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
