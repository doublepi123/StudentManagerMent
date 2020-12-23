package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DeleteCourseControl extends basefunc{
    public TextField cno;

    public void exit(ActionEvent actionEvent) {
        stage.close();
    }

    public void delete(ActionEvent actionEvent) {
        if(
                sqlHelper.executeUpdate("DELETE FROM "+username +"_COURSE WHERE cNO = '"+cno.getText()+"';" ) == 1
        ){
            messageBox.setMessage("删除成功");
            messageBox.showMessage();
            cno.setText("");
        }else{
            messageBox.setMessage("删除失败");
            messageBox.showMessage();
        }
    }
}
