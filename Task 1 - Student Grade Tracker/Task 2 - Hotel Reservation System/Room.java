public class Room {
        private int roomNumber;
        private String category;
        private boolean isBooked;

        public Room(int roomNumber, String category) {
            this.roomNumber = roomNumber;
            this.category = category;
            this.isBooked = false;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public String getCategory() {
            return category;
        }

        public boolean isBooked() {
            return isBooked;
        }

        public void book() {
            this.isBooked = true;
        }

        public void cancel() {
            this.isBooked = false;
        }
    }


