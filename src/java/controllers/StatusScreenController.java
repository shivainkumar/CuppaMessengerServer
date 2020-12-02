package controllers;

import models.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class StatusScreenController {

    @FXML
    Label startStopLabel;
    @FXML
    Label message;
    boolean isServerRunning = false;
    Server server = Server.getInstance();

    public StatusScreenController() throws IOException {
    }

    @FXML
    public void initialize(){
        if (isServerRunning){
            startStopLabel.setText("Stop");
            startStopLabel.setStyle("-fx-text-fill:#ff001e;-fx-border-color: #ff001e; -fx-border-radius: 90; -fx-border-width:5;");
            message.setText("Server running. Stopping the server will close the application.");
        }
        else {
            startStopLabel.setText("Start");
            startStopLabel.setStyle("-fx-text-fill:#14f532;-fx-border-color:#14f532;-fx-border-radius: 90; -fx-border-width:5;");
            message.setText("Click to start server.");
        }
    }

    public void switchClicked(MouseEvent mouseEvent) throws IOException {
        //stop server
        if (isServerRunning){
            isServerRunning = false;
            server.setListenForClients(false);
            server.closeServer();
            System.exit(0);
        }
        //start server
        else {
            isServerRunning = true;
            server.setListenForClients(true);
            server.listenForClients();

        }

        initialize();
    }
}
