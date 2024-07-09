package org.example.lab9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
        //1
        NumberThread numberThread = new NumberThread();
        numberThread.start();

        // 2
        Thread letterThread = new Thread(new LetterRunnable());
        letterThread.start();

        // 3
        LifecycleThread lifecycleThread = new LifecycleThread();
        System.out.println("Thread State (before start): " + lifecycleThread.getState());
        lifecycleThread.start();
        System.out.println("Thread State (after start): " + lifecycleThread.getState());
        try {
            lifecycleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread State (after join): " + lifecycleThread.getState());

        // 4
        for (int i = 0; i < 5; i++) {
            Thread timestampThread = new Thread(new TimestampRunnable());
            timestampThread.start();
        }

        // 5
        InterruptThread interruptThread = new InterruptThread();
        interruptThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptThread.interrupt();
    }
}
