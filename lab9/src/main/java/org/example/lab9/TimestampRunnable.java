package org.example.lab9;

import java.time.LocalDateTime;

public class TimestampRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Timestamp: " + LocalDateTime.now() + " - Thread Name: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new TimestampRunnable());
            thread.start();
        }
    }
}
