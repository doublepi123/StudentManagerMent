package com.lcy.studentmanagerment.tester;

import com.lcy.studentmanagerment.ui.MainWindowControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowsTester extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainWindow.fxml"));
        primaryStage.setTitle("MainWindows");

        primaryStage.setScene(new Scene(loader.load()));
        MainWindowControl mainWindowControl = loader.getController();
        mainWindowControl.init("lcy");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
