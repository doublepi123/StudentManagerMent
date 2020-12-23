package com.lcy.studentmanagerment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/LoginWindow.fxml"));
        primaryStage.setTitle("登入");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
