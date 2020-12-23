package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DeleteStudent extends basefunc{


    public TextField sno;

    public void delete(ActionEvent actionEvent) {
        if(
                sqlHelper.executeUpdate("DELETE FROM "+username +"_STUDENT WHERE SNO = '"+sno.getText()+"';" ) == 1
            ){
            messageBox.setMessage("删除成功");
            messageBox.showMessage();
            sno.setText("");
        }else{
            messageBox.setMessage("删除失败");
            messageBox.showMessage();
        }
    }

    public void exit(ActionEvent actionEvent) {
        stage.close();
    }
}
