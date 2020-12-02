package controllers;

import javafx.scene.control.Label;
import models.Server;
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
    @FXML
    Label accountCreateResult;

    Server server = Server.getInstance();

    public CreateAccountController() throws IOException {
    }


    public void createAccount(ActionEvent actionEvent) {
        if(server.addNewAccount(name.getText(), username.getText(), password.getText(), jobTitle.getText(), "Hey there! I am using Cuppa.", "1")){
            accountCreateResult.setText("Account successfully created - " + username.getText());
            name.setText("");
            username.setText("");
            password.setText("");
            jobTitle.setText("");
        }
        else{
            accountCreateResult.setText("Error creating account - " + username.getText());
        };

    }
    public void reset(ActionEvent actionEvent){
        name.setText("");
        username.setText("");
        password.setText("");
        jobTitle.setText("");
    }
}
