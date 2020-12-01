package code.Controllers;

import code.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateAccountController {
    @FXML
    TextField name;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField jobTitle;

    Server server = Server.getInstance();

    public CreateAccountController() throws IOException {
    }


    public void createAccount(ActionEvent actionEvent) {
        System.out.println(server.addNewAccount(name.getText(), username.getText(), password.getText(), jobTitle.getText(), "Hey there! I am using Cuppa.", "1"));
        name.setText("");
        username.setText("");
        password.setText("");
        jobTitle.setText("");
    }
    public void reset(ActionEvent actionEvent){
        name.setText("");
        username.setText("");
        password.setText("");
        jobTitle.setText("");
    }
}
