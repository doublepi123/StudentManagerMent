package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.model.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AddStudentControl extends BaseWindowControl{
    public TextField tID;
    public TextField tName;
    public ToggleGroup sex;
    public TextField tDept;
    public void add(ActionEvent actionEvent) {
        student.setName(tName.getText());
        student.setId(tID.getText());
        student.setDept(tDept.getText());
        if(studentDao.add(student)){
            messageBox.setMessage("添加成功");
            messageBox.showMessage();
        }
        else {
            messageBox.setMessage("添加失败");
            messageBox.showMessage();
        }
    }

    public void female(ActionEvent actionEvent) {
        student.setMale(false);
    }

    public void male(ActionEvent actionEvent) {
        student.setMale(true);
    }
}
