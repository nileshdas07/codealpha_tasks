
   import java.io.*;
import java.util.*;

    public class HotelManager {
        private List<Room> rooms = new ArrayList<>();
        private List<Booking> bookings = new ArrayList<>();
        private final String filePath = "bookings.txt";

        public HotelManager() {
            loadRooms();
            loadBookingsFromFile();
        }

        // Load initial rooms
        private void loadRooms() {
            for (int i = 101; i <= 110; i++) {
                rooms.add(new Room(i, "Standard"));
            }
            for (int i = 201; i <= 205; i++) {
                rooms.add(new Room(i, "Deluxe"));
            }
            for (int i = 301; i <= 303; i++) {
                rooms.add(new Room(i, "Suite"));
            }
        }

        // Load bookings from file
        private void loadBookingsFromFile() {
            File file = new File(filePath);
            if (!file.exists()) return;

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Booking booking = Booking.fromFileString(line);
                    bookings.add(booking);

                    // Mark room as booked
                    for (Room room : rooms) {
                        if (room.getRoomNumber() == booking.getRoomNumber()) {
                            room.book();
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading bookings file.");
            }
        }

        // Save booking to file
        private void saveBookingToFile(Booking booking) {
            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(booking.toFileString() + "\n");
            } catch (IOException e) {
                System.out.println("Error writing booking to file.");
            }
        }

        // Overwrite all bookings (used in cancel)
        private void updateBookingFile() {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                for (Booking booking : bookings) {
                    writer.println(booking.toFileString());
                }
            } catch (IOException e) {
                System.out.println("Error updating bookings file.");
            }
        }

        // Public methods
        public void viewAvailableRooms() {
            System.out.println("\n--- Available Rooms ---");
            for (Room room : rooms) {
                if (!room.isBooked()) {
                    System.out.println("Room " + room.getRoomNumber() + " (" + room.getCategory() + ")");
                }
            }
        }

        public void makeBooking(String name, String category) {
            for (Room room : rooms) {
                if (!room.isBooked() && room.getCategory().equalsIgnoreCase(category)) {
                    room.book();
                    Booking booking = new Booking(name, room.getRoomNumber(), room.getCategory(), "Paid");
                    bookings.add(booking);
                    saveBookingToFile(booking);
                    System.out.println("✅ Booking confirmed! Room No: " + room.getRoomNumber());
                    return;
                }
            }
            System.out.println("❌ No available rooms in " + category + " category.");
        }

        public void cancelBooking(int roomNumber) {
            boolean found = false;
            Iterator<Booking> iterator = bookings.iterator();

            while (iterator.hasNext()) {
                Booking booking = iterator.next();
                if (booking.getRoomNumber() == roomNumber) {
                    iterator.remove();
                    for (Room room : rooms) {
                        if (room.getRoomNumber() == roomNumber) {
                            room.cancel();
                            break;
                        }
                    }
                    updateBookingFile();
                    System.out.println("✅ Booking cancelled for Room No: " + roomNumber);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("❌ No booking found for Room No: " + roomNumber);
            }
        }

        public void viewAllBookings() {
            System.out.println("\n--- All Bookings ---");
            if (bookings.isEmpty()) {
                System.out.println("No bookings made yet.");
                return;
            }

            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
