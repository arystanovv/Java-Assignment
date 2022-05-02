package com.example.demo;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Server31_4 extends Application {
    private TextArea ta = new TextArea();

    private int threadNo = 0;

    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(2022);
                ta.appendText("Server started at " + new Date() + '\n');

                while (true) {
                    Socket socket = serverSocket.accept();

                    Platform.runLater(() -> {
                        ta.appendText("Starting thread " + threadNo++ + '\n');
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client IP /" +
                                inetAddress.getHostAddress() + '\n');

                    });

                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch(IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                outputToClient.writeUTF("You are visitor " + threadNo);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
