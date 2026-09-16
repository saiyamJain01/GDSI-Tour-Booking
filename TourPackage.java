public class TourPackage {
    // ACCESS MODIFIERS , PUBLIC CAN BE ACCESS FROM ANYWHERE
    private String destination;
    private int duration;
    private double basePrice;


    
    public TourPackage(String destination, int duration, double basePrice) {
            this.destination = destination;  // THIS KEYWORD LEFT SIDE IS VARIABLE NAME RIGHT SIDE IS CONSTRUCTOR PARAMETER
            this.duration = duration;
            this.basePrice = basePrice;
    }

    // Getter/Setter
    public String getDestination() {
        return destination;  // RETURN TYPE METHOD
    }



    public void showDetails() {
        System.out.println(" Destination: " + destination + " | Days: " + duration + " |  Price: Rs " + basePrice);
    }
}
