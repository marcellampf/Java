package org.example.assignment3;

import com.google.gson.Gson; // Importing the Gson library for JSON handling
import java.io.IOException; // Importing to handle input and output exceptions
import java.net.HttpURLConnection; // Importing to handle HTTP connections
import java.net.URL; // Importing to handle URLs
import java.util.Scanner; // Importing to read data from the HTTP response

public class PokemonController {

    // Method to get Pokemon data by name
    public Pokemon getPokemonData(String pokemonName) throws IOException {
        return fetchPokemonData("https://pokeapi.co/api/v2/pokemon/" + pokemonName);
    }

    // Method to get Pokemon data by number
    public Pokemon getPokemonDataByNumber(int pokemonNumber) throws IOException {
        return fetchPokemonData("https://pokeapi.co/api/v2/pokemon/" + pokemonNumber);
    }

    // Private method to fetch Pokemon data from a URL
    private Pokemon fetchPokemonData(String urlString) throws IOException {
        URL url = new URL(urlString); // Create a URL object from the given string
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Open an HTTP connection to the URL
        conn.setRequestMethod("GET"); // Set the HTTP method to GET
        conn.connect(); // Establish the connection

        int responseCode = conn.getResponseCode(); // Get the response code from the connection
        if (responseCode != 200) { // Check if the response is not 200 (OK)
            throw new RuntimeException("HttpResponseCode: " + responseCode); // Throw an exception in case of an error
        } else {
            StringBuilder inline = new StringBuilder(); // StringBuilder to store the response
            Scanner scanner = new Scanner(url.openStream()); // Scanner to read the response from the URL
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine()); // Read each line of the response and add it to the StringBuilder
            }
            scanner.close(); // Close the Scanner

            Gson gson = new Gson(); // Create an instance of Gson
            return gson.fromJson(inline.toString(), Pokemon.class); // Convert the JSON response to a Pokemon object
        }
    }
}
