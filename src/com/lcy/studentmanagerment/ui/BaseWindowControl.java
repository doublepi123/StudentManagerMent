package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.dao.StudentDao;
import com.lcy.studentmanagerment.daoimpl.StudentDaoImpl;
import com.lcy.studentmanagerment.model.Student;
import com.lcy.studentmanagerment.util.MessageBox;
import com.lcy.studentmanagerment.util.SQLHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseWindowControl {
    @FXML
    Button exit;
    protected SQLHelper sqlHelper;
    protected Stage stage;
    protected static String username;
    protected static StudentDao studentDao;
    protected static MessageBox messageBox;
    protected static Student student;
    public void init(String str) throws IOException {
        messageBox = new MessageBox();
        stage = (Stage) exit.getScene().getWindow();
        sqlHelper = new SQLHelper();
        username = str;
        studentDao = new StudentDaoImpl(username);
        student = new Student();
        return;
    }
    public void switchWindows(String url, String tittle){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(loader.load()));
            BaseWindowControl baseWindowControl = loader.getController();
            newStage.setTitle(tittle);
            baseWindowControl.init(username);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            messageBox.setMessage("启动功能失败");
            messageBox.showMessage();
            return;
        }
    }
    public void exit(){
        stage.close();
        return;
    }
}
