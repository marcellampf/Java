package org.example.lab12;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ApiClient {
    private static final String API_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String JSON_FILE_PATH = "users.json";

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                List<User> users = parseJsonResponse(jsonResponse);
                users.forEach(System.out::println);
                saveJsonToFile(jsonResponse);
                List<User> usersFromFile = loadJsonFromFile();
                usersFromFile.forEach(System.out::println);
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<User> parseJsonResponse(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, new TypeToken<List<User>>(){}.getType());
    }

    private static void saveJsonToFile(String jsonResponse) {
        try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
            file.write(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<User> loadJsonFromFile() {
        try (FileReader reader = new FileReader(JSON_FILE_PATH)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
