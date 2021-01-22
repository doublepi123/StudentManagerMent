package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class deleteStudentControl extends BaseWindowControl{

    public TextField tID;
    public TextField tName;

    public void find(ActionEvent actionEvent) {
        student = studentDao.find(tID.getText());
        if(student == null){
            messageBox.setMessageAndShow("学生信息未找到！！！");
            return;
        }
        tName.setText(student.getName());
    }

    public void delete(ActionEvent actionEvent) {
        if(student != null && studentDao.delete(student)) {
            messageBox.setMessageAndShow("删除成功");
            tName.setText("");
            tID.setText("");
        }
        else messageBox.setMessageAndShow("删除失败");
    }
}
