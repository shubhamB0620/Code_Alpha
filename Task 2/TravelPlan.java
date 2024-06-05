package Task2;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Destination {
    String name;
    String startDate;
    String endDate;
    double budget;
    String preferences;

    Destination(String name, String startDate, String endDate, String preferences,double budget) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget=budget;
        this.preferences = preferences;
    }
   public String fetchWeatherInfo(String name) {
        try {
            String apiKey = "4181f4e5bf68163db9507d6301013036";
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=" + apiKey;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
               String output=response.toString();
                reader.close();
                return output;
            } else {
                // Handle error cases
                System.out.println("Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 public static double getTemperature(String json) {
    // Parse the JSON to get the temperature
    int startIndex = json.indexOf("\"temp\":") + 7;
    int endIndex = json.indexOf(",", startIndex);
    String temperatureString = json.substring(startIndex, endIndex);

    // Convert temperature from Celsius to Fahrenheit
    double temperatureCelsius = Double.parseDouble(temperatureString)-273.15;
    //double temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32;
    return temperatureCelsius;
}
    public static String getWeatherDescription(String json) {
        // Parse the JSON to get the weather description
       int weatherStartIndex = json.indexOf("\"weather\":") + 10;
    int weatherEndIndex = json.indexOf("]", weatherStartIndex) + 1;
    String weatherArray = json.substring(weatherStartIndex, weatherEndIndex);

    // Parse the "main" field from the first object in the "weather" array
    int mainStartIndex = weatherArray.indexOf("\"main\":") + 8;
    int mainEndIndex = weatherArray.indexOf("\"", mainStartIndex);
    String mainWeather = weatherArray.substring(mainStartIndex, mainEndIndex);

    return mainWeather;
    }
}

public class TravelPlan {
    String userName;
    List<Destination> destinations;

    public TravelPlan(String userName) {
        this.userName = userName;
        this.destinations = new ArrayList<>();
    }

    public void addDestination(String name, String startDate, String endDate, String preferences,double budget) {
        Destination destination = new Destination(name, startDate, endDate, preferences,budget);
        destinations.add(destination);
    }
    public double calculateTotalBudget() {
        double totalBudget = 0.0;
        for (Destination destination : destinations) {
            double destinationBudget = destination.budget; 
            totalBudget += destinationBudget;
        }
        return totalBudget;
    }
    public void displayPlan() {
         System.out.println("---------------TravelPlan-----------------------");
        System.out.println("Travel Itinerary for " + userName + ":");
        for (Destination destination : destinations) {

            System.out.println("Destination: " + destination.name);
            System.out.println("Start Date: " + destination.startDate);
            System.out.println("End Date: " + destination.endDate);
            System.out.println("Preferences: " + destination.preferences);
            System.out.println("Destination budget: " + destination.budget);
            String weatherInfo = destination.fetchWeatherInfo(destination.name);
            double temperature = Destination.getTemperature(weatherInfo);
            String weatherDescription = Destination.getWeatherDescription(weatherInfo);

            System.out.println("Temperature: " + temperature + " C");
            System.out.println("Weather Description: " + weatherDescription);
            System.out.println("---------------------");
        }
    }
}