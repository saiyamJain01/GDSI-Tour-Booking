// library imports
import java.util.Scanner  ;               // for user input
import java.util.InputMismatchException; // for handling input errors
import java.util.ArrayList ;            //storing bookings
import java.io.FileWriter;             // writimg to files
import java.io.PrintWriter  ;         // writing to files
import java.io.IOException ;         // error handling

public class Main   // access modifier 
{
    public static void main(String[] args ) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        TourPackage bali =   new TourPackage("Bali Safari", 5, 100000.0);
        TourPackage thai =   new TourPackage("Thailand Getaway", 6, 110000.0);
        TourPackage ladakh =  new TourPackage("Ladakh Adventure", 7, 50000.0);
        TourPackage kashmir = new TourPackage("Kashmir Paradise", 6, 65000.0);

        ArrayList<String> ticketList = new ArrayList<>(); //bookings storage

        System.out.println("******************************************");
        System.out.println("*      Welcome to GDSI Travels CLI       *");
        System.out.println("******************************************");
        // Main menu loop
        while (choice != 6) {
            System.out.println("\n========= MAIN MENU =========");
              System.out.println("1. View Available Tour Packages");
            System.out.println("2. Book a Tour Ticket");
              System.out.println("3. View My Bookings" ) ;
            System.out.println("4. Cancel a Booking" ) ;
              System.out.println("5. Submit Feedback" );
            System.out.println("6.   Exit System");
              System.out.print("Enter option (1-6): " )   ;

            try {
                choice = scanner.nextInt()   ;
                scanner.nextLine() ; 
                // switch case statement
                switch (choice) 
                 {
                    case 1:
                        System.out.println("\n--- Destination Packages ---");
                        bali.showDetails();
                        thai.showDetails();
                        ladakh.showDetails();
                        kashmir.showDetails();
                        System.out.println("----------------------------");
                        break;
                        
                    case 2:
                        System.out.print("Enter lead passenger name: ");
                        String pName = scanner.nextLine();
                        
                        System.out.print("Enter Travel Date (DD/MM/YYYY): ");
                        String date = scanner.nextLine();

                        System.out.println("\nSelect Tour: 1=Bali, 2=Thailand, 3=Ladakh, 4=Kashmir");
                        System.out.print("Your choice: ");
                        int packChoice = scanner.nextInt();
                        
                        System.out.print("Select Class (1 = Standard, 2 = Premium [+20% extra]): ");
                        int classChoice = scanner.nextInt();

                        System.out.print("How many people are travelling?: ");
                        int people = scanner.nextInt();
                        
                        String selectedDest = "";
                        double totalBill = 0;
                     // conditional statements 
                        if (packChoice == 1) { selectedDest = bali.getDestination(); totalBill = 100000.0 * people; }
                        else if (packChoice == 2) { selectedDest = thai.getDestination(); totalBill = 110000.0 * people; }
                        else if (packChoice == 3) { selectedDest = ladakh.getDestination(); totalBill = 50000.0 * people; }
                        else if (packChoice == 4) { selectedDest = kashmir.getDestination(); totalBill = 65000.0 * people; }
                        else {
                            System.out.println("Invalid tour selection. Booking failed.");
                            break;
                        }
                        
                        String travelClass = "Standard";
                        if(classChoice == 2) {
                            travelClass = "Premium";
                            totalBill = totalBill + (totalBill * 0.20); 
                            System.out.println("* Premium Class Added (+20%) *");
                        }

                        // Group Discount 
                        if (people >= 3) {
                            System.out.println("* Yay! You got a 10% group discount for 3+ people *");
                            totalBill = totalBill - (totalBill * 0.10);
                        }

                        String info = pName + " | " + selectedDest + " | Date: " + date + " | Class: " + travelClass + " | Persons: " + people + " | Total: Rs " + totalBill;
                        ticketList.add(info);
                        // try and catch exeption handling concept 
                        try {
                            FileWriter fw = new FileWriter("ticket.txt", true); 
                            PrintWriter pw = new PrintWriter(fw);
                            pw.println("======================================");
                            pw.println("         GDSI TOUR TICKET             ");
                            pw.println("======================================");
                            pw.println("Name: " + pName);
                            pw.println("Destination: " + selectedDest);
                            pw.println("Date: " + date);
                            pw.println("Class: " + travelClass);
                            pw.println("Passengers: " + people);
                            pw.println("Amount Paid: Rs " + totalBill);
                            pw.println("Status: CONFIRMED");
                            pw.println("======================================");
                            pw.println();
                            pw.close();
                            System.out.println("\n-> Booking successful! Check your folder for 'ticket.txt'.");
                        } catch (IOException e) {
                            System.out.println("Error saving ticket: " + e.getMessage());
                        }
                        break;
                        
                    case 3:
                        System.out.println("\n--- Your Current Bookings ---");
                        if (ticketList.isEmpty()) {
                            System.out.println("No bookings found yet!");
                        } else {
                            for(int i=0; i<ticketList.size(); i++) {
                                System.out.println((i+1) + ". " + ticketList.get(i));
                            }
                        }
                        break;

                    case 4:
                        System.out.println("\n--- Cancel a Booking ---");
                        if (ticketList.isEmpty()) {
                            System.out.println("You have no bookings to cancel.");
                        } else {
                            for(int i=0; i<ticketList.size(); i++) {
                                System.out.println((i+1) + ". " + ticketList.get(i));
                            }
                            System.out.print("Enter booking number to cancel (0 to go back): ");
                            int cancelIdx = scanner.nextInt();
                            if(cancelIdx > 0 && cancelIdx <= ticketList.size()) {
                                ticketList.remove(cancelIdx - 1);
                                System.out.println("Booking cancelled successfully.");
                            } else if (cancelIdx != 0) {
                                System.out.println("Invalid booking number.");
                            }
                        }
                        break;
                        
                    case 5:
                        System.out.print("Please enter your feedback for GDSI Travels: ");
                        String feedback = scanner.nextLine();
                        try {
                            FileWriter fw2 = new FileWriter("feedback.txt", true);
                            PrintWriter pw2 = new PrintWriter(fw2);
                            pw2.println("Feedback: " + feedback);
                            pw2.close();
                            System.out.println("Thank you! Your feedback has been recorded in feedback.txt.");
                        } catch (IOException e) {
                            System.out.println("Could not save feedback.");
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for using GDSI Tour Booking System. Safe Travels!");
                        break;
                        
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Invalid Input! Please enter numbers only.");
                scanner.nextLine(); 
            }
        }
        
        scanner.close(); 
    }
}
