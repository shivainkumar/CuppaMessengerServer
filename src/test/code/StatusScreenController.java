package code;

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
            message.setText("Click the \"Stop\" button to stop the server.\nCAUTION: Doing this will stop ");
        }
        else {
            startStopLabel.setText("Start");
            message.setText("Click the \"Start\" button to start the server.");
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
