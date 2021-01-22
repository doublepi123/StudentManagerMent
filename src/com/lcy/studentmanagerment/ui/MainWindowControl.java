package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowControl extends BaseWindowControl {

    public Label welcome;

    public void addStudent(ActionEvent actionEvent) {
        switchWindows("AddStudent.fxml","添加学生");
        Student student = new Student();
    }

    public void about(ActionEvent actionEvent) {

        messageBox.setMessageAndShow("本程序由陆晨阳制作");
    }

    public void findALL(ActionEvent actionEvent) {

        switchWindows("findAllStudent.fxml","模糊查询");
    }

    public void delete(ActionEvent actionEvent) {

        switchWindows("deleteStudent.fxml","删除学生信息");
    }

    public void update(ActionEvent actionEvent) {

        switchWindows("updateStudent.fxml","精确查询/修改学生信息");
    }
}
