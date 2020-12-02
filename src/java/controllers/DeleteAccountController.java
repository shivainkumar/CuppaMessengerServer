package controllers;

import models.Server;
import models.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteAccountController {

    @FXML
    private ListView<String> list;
    private final Server server = Server.getInstance();


    public DeleteAccountController() throws IOException {
    }
    @FXML
    public void initialize(){
        refresh();
    }

    public void delete() {
        server.removeAccount(list.getSelectionModel().getSelectedItem());
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
    }

    public void refresh(){
        ArrayList<String> usernameList = new ArrayList<>();
        list.getItems().clear();

        List<User> users = server.getAllUsers();

        for (User user : users) {
            usernameList.add(user.getUsername());
        }

        Collections.sort(usernameList);

        for (String name : usernameList) {
            list.getItems().add(name);
        }
    }
}
