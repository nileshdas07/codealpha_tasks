import java.util.Scanner;

public class HotelSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManager manager = new HotelManager();

        while (true) {
            System.out.println("\n===== HOTEL RESERVATION MENU =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Booking");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> manager.viewAvailableRooms();
                case 2 -> {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room category (Standard/Deluxe/Suite): ");
                    String category = sc.nextLine();
                    System.out.println("Processing payment... Done ✅");
                    manager.makeBooking(name, category);
                }
                case 3 -> {
                    System.out.print("Enter room number to cancel: ");
                    int roomNumber = sc.nextInt();
                    manager.cancelBooking(roomNumber);
                }
                case 4 -> manager.viewAllBookings();
                case 5 -> {
                    System.out.println("Thank you for using our system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
