package org.example.assignment3;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PokemonController {

    // Method to get Pokémon data by name
    public Pokemon getPokemonData(String pokemonName) throws IOException {
        return fetchPokemonData("https://pokeapi.co/api/v2/pokemon/" + pokemonName);
    }

    // Method to get Pokémon data by number (ID)
    public Pokemon getPokemonDataByNumber(int pokemonNumber) throws IOException {
        return fetchPokemonData("https://pokeapi.co/api/v2/pokemon/" + pokemonNumber);
    }

    // Private helper method to fetch Pokémon data from the given URL
    private Pokemon fetchPokemonData(String urlString) throws IOException {
        URL url = new URL(urlString); // Create URL object
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Open connection to the URL
        conn.setRequestMethod("GET"); // Set the request method to GET
        conn.connect(); // Connect to the URL

        int responseCode = conn.getResponseCode(); // Get response code
        if (responseCode != 200) { // Check if response code is not 200 (OK)
            throw new RuntimeException("HttpResponseCode: " + responseCode); // Throw an exception if not OK
        } else {
            StringBuilder inline = new StringBuilder(); // Create a StringBuilder to store the response
            Scanner scanner = new Scanner(url.openStream()); // Open a stream to read the response
            while (scanner.hasNext()) { // Read the response line by line
                inline.append(scanner.nextLine());
            }
            scanner.close(); // Close the scanner

            Gson gson = new Gson(); // Create a Gson object for JSON parsing
            return gson.fromJson(inline.toString(), Pokemon.class); // Parse the JSON response into a Pokemon object
        }
    }
}
