import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList; 
import java.io.FileWriter;  
import java.io.PrintWriter; 
import java.io.IOException; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        TourPackage p1 = new TourPackage("Bali Safari", 5, 100000.0);
        TourPackage p2 = new TourPackage("Thailand Getaway", 6, 110000.0);
        TourPackage p3 = new TourPackage("Ladakh Adventure", 7, 50000.0);

        // THIS WILL STORE ALL THE BOOKING DETAILS
        ArrayList<String> bookedTickets = new ArrayList<>();

        System.out.println("GDSI tour booking system is happy to welcome our client!");

        while (choice != 3) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View Tour Packages");
            System.out.println("2. Book a Tour (Generates Ticket)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("\n    Available Packages    ");
                        p1.showDetails();
                        p2.showDetails();
                        p3.showDetails();
                        System.out.println("--------------------------");
                        break;
                        
                    case 2:
                        System.out.print("Enter your name: ");
                        String passengerName = scanner.nextLine();
                        
                        System.out.print("Which page? (1=Bali, 2=Thailand, 3=Ladakh): ");
                        int packChoice = scanner.nextInt();
                        
                        String selectedDest = "";
                        if (pChoice == 1) selectedDest = p1.getDestination();
                        else if (pChoice == 2) selectedDest = p2.getDestination();
                        else if (pChoice == 3) selectedDest = p3.getDestination();
                        else {
                            System.out.println("Invalid page selection.");
                            break;
                        }

                        
                        String bookingInfo = "Passenger: " + passengerName + " | Destination: " + selectedDest;
                        bookedTickets.add(bookingInfo);

                    
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
                        System.out.println("Exiting GDSI system. Safe travels and happyyy journeyyyyy !");
                        break;
                        
                    default:
                        System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Invalid input! Please type a NUMBER .");
                scanner.nextLine();
            }
        }
        
        scanner.close(); 
    }
}
