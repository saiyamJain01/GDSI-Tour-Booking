public class TourPackage {
    
    // Encapsulation
    private String destination ;
    private int duration ;
    private double basePrice  ;
    private int availableSeats; 
    private double rating  ;  

    // Constructor 
    public TourPackage(  String destination, int duration,  double basePrice  ) 
    {
        this.destination = destination;  
        this.duration = duration ;
        this.basePrice = basePrice ;
        this.availableSeats = 25  ; //  seats
        this.rating = 4.5;  } //  rating 
    
// constructor overloading
    public String getDestination()
     {
        return destination  ;  
    }

    public int getDuration()
     {
        return duration ;
    } 

    public double getBasePrice() 
     {
        return basePrice  ;
    }

    public int getAvailableSeats() 
    {
        return availableSeats ;
    }

    public double   getRating() {
        return rating;
    }

    // getter setter concept
    public void setRating (double rating)
     {
        this .rating = rating ;
    }

    // Seat booking logic
    public void reduceAvailableSeats (int seats)
     {
        if (seats <= this.availableSeats)
             {
            this.availableSeats -= seats  ;
     
              }
    }

   
    public void showDetails() {
        System.out.println("-> Destination: " + destination.toUpperCase());
        System.out.println("   Duration: " + duration + " Days | Base Price: Rs " + basePrice);
        System.out.println("   Rating: " + rating + "/5.0 | Seats Left: " + availableSeats);
    }
}
