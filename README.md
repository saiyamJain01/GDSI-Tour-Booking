# GDSI Tour Booking System

## Project Summary
The GDSI Tour Booking System is an advanced, console-based Java application developed to streamline the process of browsing and booking travel packages. Designed strictly as a Command Line Interface (CLI) tool, the system provides an interactive experience for users to view destinations, manage bookings, and submit feedback. This project practically demonstrates core Java modules including Object-Oriented Programming (OOP), Flow Control, Exception Handling, Collection Frameworks (`ArrayList`), and File I/O Streams.

## Student Details
* **Name:** Saiyam Jain
* **Registration Number:** 25BAI10938
* **College:** VIT Bhopal University

## Features
* **Interactive CLI Menu:** Navigate through 6 different system options seamlessly.
* **Advanced OOP & Encapsulation:** Tour details (Destination, Duration, Base Price, Ratings, Available Seats) are encapsulated securely using getter/setter methods.
* **Smart Booking Logic:** Automatically calculates total bills, applies a 20% premium class surcharge, and grants a 10% group discount for 3 or more passengers.
* **Dynamic Collections:** Uses `ArrayList` to temporarily store, display, and delete (cancel) bookings during runtime.
* **Robust Error Handling:** The system handles invalid user inputs (e.g., characters instead of numbers) using `try...catch` blocks to prevent unexpected crashes.
* **Dual File I/O Automation:** 
  * Confirmed bookings are generated as physical tickets in a `ticket.txt` file.
  * User feedback is persistently appended to a separate `feedback.txt` file.

## Requirements
* Java Development Kit (JDK) 8 or higher installed on your system.

## Setup & Execution Instructions
Follow these step-by-step instructions to compile and run the project from your terminal/command line. Ensure you are running this in a terminal environment as this is strictly a CLI-based application.

1. **Clone the Repository:** 
    git clone https://github.com/saiyamJain01/GDSI-Tour-Booking.git

2. **Navigate to the Directory:** 
    cd GDSI-Tour-Booking

3. **Compile the Java Files:** Compile both source files together.
    javac Main.java TourPackage.java

4. **Run the Application:** To launch the booking system, execute the Main class.
    java Main

## Examiner Guide (Note for Evaluation)
This project is completely console-based and fulfills all course requirements via the command line without any GUI-based setup. Upon successful booking or feedback submission, please check the root directory for the generated `ticket.txt` and `feedback.txt` output files to verify the File I/O implementation.
