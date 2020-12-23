package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DeleteSCControl extends basefunc{

    public TextField cno;
    public TextField sno;

    public void exit(ActionEvent actionEvent) {
        stage.close();
    }

    public void delete(ActionEvent actionEvent) {
        if(
                sqlHelper.executeUpdate("DELETE FROM "+username +"_SC WHERE SNO = '"+sno.getText()+"'AND CNO = '"+cno.getText()+ "';" ) == 1
        ){
            messageBox.setMessage("删除成功");
            messageBox.showMessage();
            sno.setText("");
            cno.setText("");
        }else{
            messageBox.setMessage("删除失败");
            messageBox.showMessage();
        }
    }
}
