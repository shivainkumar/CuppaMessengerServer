package models;

import controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ServerDriver extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader logLoader = new FXMLLoader();
        logLoader.setLocation(getClass().getResource("/views/main.fxml"));
        Parent root = logLoader.load();
        Controller mainController = logLoader.getController();

        primaryStage.setTitle("Cuppa Messenger Server");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene rootScene = new Scene(root);
        rootScene.getStylesheets().add(getClass().getResource("/styles/main.css").toExternalForm());
        primaryStage.setScene(rootScene);
        mainController.setStage(primaryStage);
        primaryStage.getIcons().add(new Image("/cuppa.png"));

        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
