import java.util.Arrays;
import java.util.Scanner;

public class ReservationSystem {
    private static final int MAX_RESERVATIONS = 25;
    private static String[] reservations = new String[MAX_RESERVATIONS];
    private static int count = 0;

    public static void makeReservation(String name) {
        if (count >= MAX_RESERVATIONS) {
            System.out.println("Sorry, no more reservations can be made.");
        } else if (findReservation(name) != -1) {
            System.out.println("Sorry, the name is already reserved.");
        } else {
            reservations[count] = name;
            count++;
            System.out.println("Reservation made for " + name);
        }
    }

    public static void cancelReservation(String name) {
        int index = findReservation(name);
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                reservations[i] = reservations[i + 1];
            }
            count--;
            System.out.println("Reservation canceled for " + name);
        } else {
            System.out.println("No reservation found for " + name);
        }
    }

    public static void displayReservations() {
        System.out.println("Current Reservations:");
        if (count == 0) {
            System.out.println("No reservations found.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(reservations[i]);
            }
        }
    }

    private static int findReservation(String name) {
        for (int i = 0; i < count; i++) {
            if (reservations[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("==== Reservation System ====\n====Maximum 25 Reservations can be made====");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Display reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name for reservation: ");
                    String name = scanner.nextLine();
                    makeReservation(name);
                    break;
                case 2:
                    System.out.print("Enter name to cancel reservation: ");
                    name = scanner.nextLine();
                    cancelReservation(name);
                    break;
                case 3:
                    displayReservations();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        System.out.println("Reservation system closed.");
    }
}
