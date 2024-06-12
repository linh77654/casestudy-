package ParkingSystem;

import org.jetbrains.annotations.NotNull;

public class Customer implements Parkable {
    private String name;
    private Vehicle vehicle;
    private Ticket ticket;

    public Customer(String name) {
        this.name = name;

    }

    @Override
    public Ticket parkVehicle(@NotNull ParkingLot parkingLot, String licensePlate) {
        this.vehicle = new Vehicle(licensePlate);
        this.ticket = parkingLot.parkVehicle(vehicle);
        if (this.ticket != null) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Xe đã được đỗ. Số phiếu của bạn là: " + ticket.getTicketNumber());
            System.out.println("--------------------------------------------------------------");
        }
        return ticket;
    }

    public boolean addTicket(@NotNull ParkingLot parkingLot, Ticket ticket) {
        boolean result = parkingLot.addTicket(ticket);
        if (result) {
            System.out.println("Phiếu đã được thêm. Số phiếu của bạn là: " + ticket.getTicketNumber());
        }
        return result;
    }

    @Override
    public void retrieveVehicle(@NotNull ParkingLot parkingLot, int ticketNumber) {
        Vehicle vehicle = parkingLot.retrieveVehicle(ticketNumber);
        if (vehicle != null) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Xe đã được lấy biển số xe là : " + vehicle.getLicensePlate());
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("|                 Số phiếu không hợp lệ.                     |");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public String getName() {
        return name;
    }

}
