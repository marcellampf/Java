package org.example.lab9;

public class LetterRunnable implements Runnable {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new LetterRunnable());
        thread.start();
    }
}
