package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.util.SQLHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentControl extends basefunc{
    public TextField sno;
    public TextField sname;
    public TextField sex;
    public TextField sdept;
    public Button bAdd;
    public Button bQuit;
    public Button bEmpty;
    private void empty(){
        sname.setText("");
        sno.setText("");
        sdept.setText("");
        sex.setText("");
    }
    public void empty(ActionEvent actionEvent) {
        empty();
    }

    public void add(ActionEvent actionEvent) {
        if(sqlHelper.executeUpdate("UPDATE "+username+"_STUDENT SET SNAME = '"+sname.getText()+"' WHERE SNO = '"+sno.getText()+"';") == 1 &&
        sqlHelper.executeUpdate("UPDATE "+username+"_STUDENT SET SEX = '"+sex.getText()+"' WHERE SNO = '"+sno.getText()+"';") == 1 &&
        sqlHelper.executeUpdate("UPDATE "+username+"_STUDENT SET SDEPT = '"+sdept.getText()+"' WHERE SNO = '"+sno.getText()+"';") == 1){
            messageBox.setMessage("修改成功");
            messageBox.showMessage();
            empty();
        }else{
            messageBox.setMessage("修改失败");
            messageBox.showMessage();
        }
    }

    public void find(ActionEvent actionEvent) {
        ResultSet rs = sqlHelper.executeQuery("SELECT * FROM "+username+"_STUDENT WHERE SNO ='"+sno.getText()+"';");
        try {
            if(rs.next()){
                sname.setText(rs.getString("SNAME"));
                sex.setText(rs.getString("SEX"));
                sdept.setText(rs.getString("SDEPT"));
            }
        } catch (SQLException throwables) {
            messageBox.setMessage("未找到该学生");
            messageBox.showMessage();
            throwables.printStackTrace();
        }
    }
}
