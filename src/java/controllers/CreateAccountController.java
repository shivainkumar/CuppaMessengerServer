package controllers;

import javafx.scene.control.Label;
import models.Server;
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


    public void createAccount() {
        String enteredName = name.getText();
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();
        String enteredJob = password.getText();
        if(enteredName.equals("") || enteredUsername.equals("") || enteredPassword.equals("") || enteredJob.equals("")){
            accountCreateResult.setText("Fields cannot be empty");
        }
        else {
            if (server.addNewAccount(enteredName, enteredUsername, enteredPassword, enteredJob, "Hey there! I am using Cuppa.", "1")) {
                accountCreateResult.setText("Account successfully created - " + username.getText());
                name.setText("");
                username.setText("");
                password.setText("");
                jobTitle.setText("");
            }
            else {
                accountCreateResult.setText("Duplicate username - " + username.getText());
            }
        }
    }
    public void reset(){
        name.setText("");
        username.setText("");
        password.setText("");
        jobTitle.setText("");
    }
}
