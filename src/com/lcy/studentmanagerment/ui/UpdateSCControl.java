package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateSCControl extends basefunc {

    public Button bEmpty;
    public Button bQuit;
    public TextField cno;
    public TextField sno;
    public TextField grade;

    public void add(ActionEvent actionEvent) {
        if(sqlHelper.executeUpdate("UPDATE "+username+"_SC SET GRADE = '"+grade.getText()+
                "' WHERE CNO = '"+cno.getText()+"' AND SNO = '"+sno.getText()+ "';") == 1)
        {
            messageBox.setMessage("修改成功");
            messageBox.showMessage();
            empty();
        }else{
            messageBox.setMessage("修改失败");
            messageBox.showMessage();
        }
    }

    public void find(ActionEvent actionEvent) {
        ResultSet rs = sqlHelper.executeQuery("SELECT * FROM "+username+"_SC WHERE SNO ='"+sno.getText()+"' AND CNO = '"+cno.getText()+ "';");
        try {
            if(rs.next()){
                grade.setText(rs.getString("GRADE"));
            }
        } catch (SQLException throwables) {
            messageBox.setMessage("未找到该信息");
            messageBox.showMessage();
            throwables.printStackTrace();
        }
    }
    public void empty(){
        cno.setText("");
        sno.setText("");
        grade.setText("");
    }
    public void empty(ActionEvent actionEvent) {
        empty();
    }
}
