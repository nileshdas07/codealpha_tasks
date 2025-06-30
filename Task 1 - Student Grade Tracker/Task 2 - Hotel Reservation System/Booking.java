public class Booking {
        private String customerName;
        private int roomNumber;
        private String category;
        private String paymentStatus;

        public Booking(String customerName, int roomNumber, String category, String paymentStatus) {
            this.customerName = customerName;
            this.roomNumber = roomNumber;
            this.category = category;
            this.paymentStatus = paymentStatus;
        }

        public String toFileString() {
            return customerName + "," + roomNumber + "," + category + "," + paymentStatus;
        }

        public static Booking fromFileString(String line) {
            String[] parts = line.split(",");
            return new Booking(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
        }

        @Override
        public String toString() {
            return "Customer: " + customerName + ", Room: " + roomNumber +
                    " (" + category + "), Payment: " + paymentStatus;
        }

        public int getRoomNumber() {
            return roomNumber;
        }
    }


