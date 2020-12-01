package code;

import code.Controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ServerDriver extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader logLoader = new FXMLLoader();
        logLoader.setLocation(getClass().getResource("/main.fxml"));
        Parent root = logLoader.load();
        Controller mainController = logLoader.getController();

        primaryStage.setTitle("Cuppa Messenger Server");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        mainController.setStage(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
