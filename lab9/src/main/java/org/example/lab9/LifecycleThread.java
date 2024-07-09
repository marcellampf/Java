package org.example.lab9;

public class LifecycleThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread State (run): " + getState());
            Thread.sleep(2000);
            System.out.println("Thread State (after sleep): " + getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LifecycleThread thread = new LifecycleThread();
        System.out.println("Thread State (before start): " + thread.getState());
        thread.start();
        System.out.println("Thread State (after start): " + thread.getState());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread State (after join): " + thread.getState());
    }
}
