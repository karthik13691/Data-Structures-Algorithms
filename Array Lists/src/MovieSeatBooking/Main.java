package MovieSeatBooking;

import MovieSeatBooking.controller.SeatBooking;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The Main class provides a command-line interface for managing movie seat bookings.
 * Users can add new bookings, cancel existing bookings, update bookings, and display all current bookings.
 */
public class Main {
    public static void main(String[] args) {
        // Take input using Scanner class
        Scanner keyboard = new Scanner(System.in);
        // Create an object of SeatBooking class
        SeatBooking bookingManager = new SeatBooking();

        while (true) {
            System.out.println("\t1. Add Booking\t2. Cancel Booking\t3. Update Booking\t4. Display Bookings\t5. Exit");
            System.out.print("Choose an option: ");
            // Choose an option
            int choice = -1;
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                keyboard.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            switch (choice) {
                case 1:
                    // Add New Seat Booking
                    System.out.print("Enter the seat number you want to book: ");
                    String seatNumber = keyboard.nextLine();
                    SeatBooking.addNewBooking(seatNumber);
                    break;
                case 2:
                    // Cancel Booking
                    System.out.print("Enter the seat number you want to cancel: ");
                    String cancelSeatNumber = keyboard.nextLine();
                    SeatBooking.cancelBooking(cancelSeatNumber);
                    break;
                case 3:
                    // Update Booking
                    System.out.print("Enter the old seat number you want to update: ");
                    String oldSeatNumber = keyboard.nextLine();
                    System.out.print("Enter the new seat number you want to book: ");
                    String newSeatNumber = keyboard.nextLine();
                    SeatBooking.updateBooking(oldSeatNumber, newSeatNumber);
                    break;
                case 4:
                    // Display All Bookings
                    bookingManager.displayBookings();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    keyboard.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}