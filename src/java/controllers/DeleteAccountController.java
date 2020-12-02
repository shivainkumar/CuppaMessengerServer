package controllers;

import models.Server;
import models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;

public class DeleteAccountController {


    @FXML
    ListView list;
    @FXML
    Button deleteBtn;

    Server server = Server.getInstance();


    public DeleteAccountController() throws IOException {
    }
    @FXML
    public void initialize(){
        refresh();
    }

    public void delete() {
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
