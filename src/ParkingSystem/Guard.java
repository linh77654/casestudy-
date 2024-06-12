    package ParkingSystem;

    public class Guard extends Role implements Parkable {
        private String employeeId;

        public Guard(String name, String employeeId) {
            super(name);
            this.employeeId = employeeId;
        }

        @Override
        public Ticket parkVehicle(ParkingLot parkingLot, String licensePlate) {
            return null;
        }

        @Override
        public void retrieveVehicle(ParkingLot parkingLot, int ticketNumber) {
        }

        public void manageParkedVehicles(ParkingLot parkingLot) {
            System.out.println("Quản lý các xe đã đỗ...");
            System.out.println("--------------------------------");

            parkingLot.listParkedVehicles();
        }
    }