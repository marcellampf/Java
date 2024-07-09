package org.example.lab9;

public class InterruptThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println("Running...");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        InterruptThread thread = new InterruptThread();
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
