package com.example.demo;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Client31_4 extends Application {
    DataInputStream fromServer = null;

    private Label label  = new Label("");

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.getChildren().add(label);

        Scene scene = new Scene(pane, 300, 75);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            Socket socket = new Socket("localhost", 2022);
            fromServer = new DataInputStream(socket.getInputStream());
            label.setText(fromServer.readUTF());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

