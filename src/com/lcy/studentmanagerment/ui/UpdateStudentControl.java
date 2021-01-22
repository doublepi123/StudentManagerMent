package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class updateStudentControl extends BaseWindowControl{

    public TextField tID;
    public TextField tName;
    public TextField tDept;
    public RadioButton male;
    public ToggleGroup sex;
    public RadioButton female;

    public void setmale(ActionEvent actionEvent) {
        student.setMale(true);
    }

    public void setfemale(ActionEvent actionEvent) {
        student.setMale(false);
    }

    public void find(ActionEvent actionEvent) {
        student =  studentDao.find(tID.getText());
        if(student == null){
            messageBox.setMessageAndShow("未找到该学生信息！！！");
            return;
        }
        tName.setText(student.getName());
        tDept.setText(student.getDept());
        if(student.getSex().endsWith("男")){
            female.setSelected(false);
            male.setSelected(true);
        }
        if(student.getSex().endsWith("女")) {
            male.setSelected(false);
            female.setSelected(true);
        }
    }

    public void update(ActionEvent actionEvent) {
        student.setName(tName.getText());
        student.setDept(tDept.getText());
        if(studentDao.update(student)){
            messageBox.setMessageAndShow("修改成功");
        }
        else messageBox.setMessageAndShow("修改失败");

    }
}
