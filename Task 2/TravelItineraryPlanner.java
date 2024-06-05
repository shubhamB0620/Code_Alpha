package Task2;
//Create a travel itinerary planner that allows users to input
//destinations, dates, and preferences to generate a detailed
//travel plan. Include features like maps, weather information,
//and budget calculations.

import java.util.Scanner;

public class TravelItineraryPlanner {
    public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
        System.out.print("Enter your name: ");
        String userName = input.nextLine();

        TravelPlan travelPlanner = new TravelPlan(userName);
       
        while (true) {
            System.out.print("Enter destination name (or 'exit' to finish): ");
            String destinationName = input.nextLine();

            if (destinationName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter start date (e.g., YYYY-MM-DD): ");
            String startDate = input.nextLine();

            System.out.print("Enter end date (e.g., YYYY-MM-DD): ");
            String endDate = input.nextLine();

            System.out.print("Enter preferences for " + destinationName + ": ");
            String preferences = input.nextLine();
            System.out.print("Enter Budget for :" + destinationName + ": ");
            double budget = input.nextDouble();
            input.nextLine();
            travelPlanner.addDestination(destinationName, startDate, endDate, preferences,budget);
               }

        travelPlanner.displayPlan();
        double totalBudget = travelPlanner.calculateTotalBudget();
        System.out.println("\nTotal Budget for " + userName + ": $" + totalBudget);

    }

        System.out.println("Thank you for using the travel planner!");
    }
}