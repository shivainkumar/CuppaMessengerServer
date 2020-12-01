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
import java.util.List;

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
        refresh();
    }

    public void delete() throws IOException {
        server.removeAccount(list.getSelectionModel().getSelectedItem().toString());

    }

    public void refresh(){
        list.getItems().clear();
        List<User> users = server.getAllUsers();
        for (int i = 0; i< users.size(); i++){
            list.getItems().add(users.get(i).getUsername());
        }
    }
}
