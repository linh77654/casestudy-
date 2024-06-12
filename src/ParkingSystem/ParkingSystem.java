package ParkingSystem;

import java.util.Scanner;

public class ParkingSystem {

    private static  ParkingLot parkingLot = new ParkingLot(5);
    private static Guard guard = new Guard("John", "G123");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                displayMenu();
                choice = scanner.nextInt();
                handleUserChoice(choice, scanner);
            } while (choice != 5);
        }
    }

    private static void displayMenu() {
        System.out.println("Chào mừng đến với Hệ thống Đỗ Xe");
        System.out.println("1. Đỗ Xe");
        System.out.println("2. Lấy Xe");
        System.out.println("3. Bảo Vệ - Quản Lý Xe Đã Đỗ");
        System.out.println("4. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1 -> parkVehicle(scanner); // xử dụng cú pháp lambda
            case 2 -> retrieveVehicle(scanner);
            case 3 -> guard.manageParkedVehicles(parkingLot);
            case 4 -> System.out.println("Cảm ơn bạn đã sử dụng hệ thống đỗ xe.");
            default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    private static void parkVehicle(Scanner scanner) {
        System.out.print("Nhập biển số xe: ");
        String licensePlate = scanner.next();
        Customer customer = new Customer("Khách hàng");
        Ticket ticket = customer.parkVehicle(parkingLot, licensePlate);
        if (ticket != null) {
            System.out.println("Vui lòng giữ phiếu: " + ticket.getTicketNumber());
            System.out.println("-----------------------------------------");
        }
    }

    private static void retrieveVehicle(Scanner scanner) {
        System.out.print("Nhập số phiếu: ");
        int ticketNumber = scanner.nextInt();
        Customer customer = new Customer("Khách hàng");
        customer.retrieveVehicle(parkingLot, ticketNumber);
    }
}
