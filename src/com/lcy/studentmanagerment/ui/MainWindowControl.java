package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.util.SQLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowControl {
    public MenuItem iexit;
    public Button bexit;
    public Label mWelcome;
    public Button bAddStudent;
    public Button bUpdateStudent;
    MessageBox messageBox;
    Stage stage;
    static SQLHelper sqlHelper;
    public MenuItem bAbout;
    private String username;
    public void init(String s) throws IOException {
        username = s;
        messageBox = new MessageBox();
        sqlHelper = new SQLHelper();
        mWelcome.setText(username+",欢迎回来！");
    }

    public void showAbout(ActionEvent actionEvent) {
        messageBox.setMessage("本程序由陆晨阳制作，版权归制作人所有");
        messageBox.showMessage();
    }

    public void exit(ActionEvent actionEvent) {
        stage = (Stage)bexit.getScene().getWindow();
        stage.close();
    }

    public void AddStudent(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("AddStudentWindos.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        AddStudentWindosControl addStudentWindosControl =  loader.getController();
        stage.setTitle("添加学生信息");
        addStudentWindosControl.init(username);
        stage.show();
    }

    public void UpdateStudent(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("UpdateStudent.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        UpdateStudentControl addCourseControl =  loader.getController();
        stage.setTitle("修改学生信息");
        addCourseControl.init(username);
        stage.show();
    }

    public void addCourse(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("AddCourse.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        AddCourseControl addCourseControl =  loader.getController();
        stage.setTitle("添加课程信息");
        addCourseControl.init(username);
        stage.show();
    }

    public void addSC(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("AddSC.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        AddSCControl addSCControl =  loader.getController();
        stage.setTitle("添加选课信息");
        addSCControl.init(username);
        stage.show();
    }

    public void UpdateCourse(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("UpdateCourse.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        UpdateCourseControl addSCControl =  loader.getController();
        stage.setTitle("修改课程信息");
        addSCControl.init(username);
        stage.show();
    }

    public void UpdateSC(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("UpdateSC.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        UpdateSCControl addSCControl =  loader.getController();
        stage.setTitle("修改选课信息");
        addSCControl.init(username);
        stage.show();
    }

    public void DeleteStudent(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("DeleteStudent.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        DeleteStudent addSCControl =  loader.getController();
        stage.setTitle("删除学生信息");
        addSCControl.init(username);
        stage.show();
    }

    public void DeleteCourse(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("DeleteCourse.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        DeleteCourseControl addSCControl =  loader.getController();
        stage.setTitle("删除课程信息");
        addSCControl.init(username);
        stage.show();
    }

    public void DeleteSC(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("DeleteSC.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        DeleteSCControl addSCControl =  loader.getController();
        stage.setTitle("删除选课信息");
        addSCControl.init(username);
        stage.show();
    }
}
