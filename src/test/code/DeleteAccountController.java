package code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteAccountController {

    @FXML
    Node contactTile;
    @FXML
    GridPane list;
    @FXML
    Button deleteBtn;
    @FXML
    Button clearBtn;


    static UserList userList  = UserList.getInstance();
    static ArrayList<User> users;
    ArrayList<code.CheckboxContactTileController> checkBoxContactControllers;
    public void loadContacts() throws IOException {
        checkBoxContactControllers = new ArrayList<>();
        users = userList.getUsers();
        int j = 0;
        int k = 0;
        if(users != null){
            for (User user : users) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/checkBoxContactTile.fxml"));
                    contactTile = loader.load();
                    code.CheckboxContactTileController infoSet = loader.getController();

                    infoSet.setInfo(user);
                    list.add(contactTile, k, j);
                    checkBoxContactControllers.add(infoSet);
                    //adding to the grid
                    k++;
                    if (k == 3){
                        k = 0;
                        j++;
                    }
                }

            }
        }


    public ArrayList<String> selectedUsers(ArrayList<code.CheckboxContactTileController> CheckBoxContactControllers){
        ArrayList<String> selectedUsers = new ArrayList<>();
        for (int i = 0; i < CheckBoxContactControllers.size(); i++){
            if(CheckBoxContactControllers.get(i).isChecked()){
                selectedUsers.add(CheckBoxContactControllers.get(i).user.getUsername());
            }
        }
        return selectedUsers;
    }

}
