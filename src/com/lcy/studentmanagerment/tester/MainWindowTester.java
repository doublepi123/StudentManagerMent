package com.lcy.studentmanagerment.tester;

import com.lcy.studentmanagerment.ui.MainWindowControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowTester extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainWindow.fxml"));
        stage.setScene(new Scene(loader.load()));
        MainWindowControl mainWindowControl  = loader.getController();
        mainWindowControl.init("lcy");
        stage.setTitle("学生信息管理系统");
        stage.show();
        primaryStage.close();
    }
}
