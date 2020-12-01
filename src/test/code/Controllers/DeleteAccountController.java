package code.Controllers;

import code.Server;
import code.User;
import code.UserList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteAccountController {


    @FXML
    ListView list;
    @FXML
    Button deleteBtn;
    @FXML
    Button clearBtn;

    Server server = Server.getInstance();


    public DeleteAccountController() throws IOException {
    }
    @FXML
    public void initialize(){

        list.getItems().addAll(server.getAllUsers());

    }

    public void delete() throws IOException {
        System.out.println(list.getSelectionModel().getSelectedItem());
        server.removeUser((User)list.getSelectionModel().getSelectedItem());

    }
}
