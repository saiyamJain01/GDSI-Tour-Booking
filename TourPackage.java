public class TourPackage {
    // Encapsulation: Variables ko private rakha hai taki bahar se direct change na ho
    private String destination;
    private int durationDays;
    private double basePrice;

    // Constructor: Jab naya package banega tab ye run hoga
    public TourPackage(String destination, int durationDays, double basePrice) {
        this.destination = destination;
        this.durationDays = durationDays;
        this.basePrice = basePrice;
    }

    // Getter method: Destination ka naam read karne ke liye
    public String getDestination() {
        return destination;
    }

    // Package details print karne ka method
    public void showDetails() {
        System.out.println(" Destination: " + destination + " | Days: " + durationDays + " |  Price: Rs " + basePrice);
    }
}