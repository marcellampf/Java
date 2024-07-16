package org.example.lab10;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleApiHttpClient client = new SimpleApiHttpClient();
        try {
            String data = client.fetchData("https://jsonplaceholder.typicode.com/posts");

            List<Post> posts = client.parseJsonPosts(data);

            for (Post post : posts) {
                System.out.println(post);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
