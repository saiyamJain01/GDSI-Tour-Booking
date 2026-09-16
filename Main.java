import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList; // Module 4
import java.io.FileWriter;  // Module 4
import java.io.PrintWriter; // Module 4
import java.io.IOException; // Module 4

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        TourPackage pack1 = new TourPackage("Bali Safari", 5, 45000.0);
        TourPackage pack2 = new TourPackage("Thailand Getaway", 6, 35000.0);
        TourPackage pack3 = new TourPackage("Ladakh Adventure", 7, 25000.0);

        // Module 4: ArrayList booking details store karne ke liye
        ArrayList<String> bookedTickets = new ArrayList<>();

        System.out.println("Welcome to GDSI Tour Booking System!");

        while (choice != 3) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View Tour Packages");
            System.out.println("2. Book a Tour (Generates Ticket)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Ye line Scanner ko saaf karti hai text input lene se pehle

                switch (choice) {
                    case 1:
                        System.out.println("\n--- Available Packages ---");
                        pack1.showDetails();
                        pack2.showDetails();
                        pack3.showDetails();
                        System.out.println("--------------------------");
                        break;
                        
                    case 2:
                        System.out.print("Enter passenger name: ");
                        String passengerName = scanner.nextLine();
                        
                        System.out.print("Which package? (1=Bali, 2=Thailand, 3=Ladakh): ");
                        int packChoice = scanner.nextInt();
                        
                        String selectedDest = "";
                        if (packChoice == 1) selectedDest = pack1.getDestination();
                        else if (packChoice == 2) selectedDest = pack2.getDestination();
                        else if (packChoice == 3) selectedDest = pack3.getDestination();
                        else {
                            System.out.println("Invalid package selection.");
                            break;
                        }

                        // ArrayList mein add kiya
                        String bookingInfo = "Passenger: " + passengerName + " | Destination: " + selectedDest;
                        bookedTickets.add(bookingInfo);

                        // Module 4: File I/O se .txt file banana
                        try {
                            FileWriter fw = new FileWriter("ticket.txt", true); // true mtlb naya data append hoga
                            PrintWriter pw = new PrintWriter(fw);
                            pw.println("=== GDSI TOUR TICKET ===");
                            pw.println(bookingInfo);
                            pw.println("Status: CONFIRMED");
                            pw.println("========================");
                            pw.close();
                            System.out.println("-> Booking successful! Check your folder for 'ticket.txt'.");
                        } catch (IOException e) {
                            System.out.println("Error saving ticket: " + e.getMessage());
                        }
                        break;
                        
                    case 3:
                        System.out.println("Exiting GDSI system. Safe travels!");
                        break;
                        
                    default:
                        System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Invalid input! Please type a NUMBER, not letters.");
                scanner.nextLine();
            }
        }
        
        scanner.close(); 
    }
}