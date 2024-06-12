package ParkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final Map<Integer, Ticket> parkedVehicles = new HashMap<>();
    private List<ParkingSlot> parkingSlots;

    public ParkingLot() {
        this(5);
    }

    public ParkingLot(int numberOfSlots) {
        if (numberOfSlots > 0 && numberOfSlots <= 5) {
            parkingSlots = new ArrayList<>();
            for (int i = 1; i <= numberOfSlots; i++) {
                parkingSlots.add(new ParkingSlot(i));
            }
        } else {
            throw new IllegalArgumentException("Số lượng chỗ đỗ xe không hợp lệ. Vui lòng chọn số lượng từ 1 đến 5.");
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSlot slot : parkingSlots) {
            if (!slot.isOccupied()) {
                slot.parkCar(vehicle);
                Ticket ticket = new Ticket(vehicle);
                parkedVehicles.put(ticket.getTicketNumber(), ticket);
                return ticket;
            }
        }
        System.out.println("============================================================");
        System.out.println("|        Bãi đỗ xe đã đầy Xin quay lại sau          |");
        System.out.println("============================================================");
        return null;
    }

    public boolean addTicket(Ticket ticket) {
        for (ParkingSlot slot : parkingSlots) {
            if (!slot.isOccupied()) {
                slot.parkCar(ticket.getVehicle());
                parkedVehicles.put(ticket.getTicketNumber(), ticket);
                return true;
            }
        }
        System.out.println("Bãi đỗ xe đã đầy. Không thể thêm phiếu.");
        return false;
    }

    public Vehicle retrieveVehicle(int ticketNumber) {
        Ticket ticket = parkedVehicles.remove(ticketNumber);
        if (ticket != null) {
            for (ParkingSlot slot : parkingSlots) {
                if (slot.isOccupied() && slot.getParkedCar().getLicensePlate().equals(ticket.getVehicle().getLicensePlate())) {
                    slot.removeCar();
                    return ticket.getVehicle();
                }
            }
        }
        return null;
    }

    public void listParkedVehicles() {
        System.out.println("Danh sách các xe đã đỗ:");
        System.out.println("----------------------------------------------------------");
        for (Ticket ticket : parkedVehicles.values()) {
            System.out.println("Số phiếu: " + ticket.getTicketNumber() + ", Biển số: " + ticket.getVehicle().getLicensePlate());
            System.out.println("--------------------------------------------------------");

        }
    }
}
