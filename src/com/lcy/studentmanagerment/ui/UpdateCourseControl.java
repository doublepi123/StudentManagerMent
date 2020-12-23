package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCourseControl extends basefunc{
    public TextField cname;
    public TextField cno;
    public TextField cex;
    public Button bQuit;
    public Button bEmpty;

    public void add(ActionEvent actionEvent) {
        if(sqlHelper.executeUpdate("UPDATE "+username+"_COURSE SET CNAME = '"+cname.getText()+"' WHERE CNO = '"+cno.getText()+"';") == 1 &&
                sqlHelper.executeUpdate("UPDATE "+username+"_COURSE SET CREDIT = '"+cex.getText()+"' WHERE CNO = '"+cno.getText()+"';") == 1)
        {
            messageBox.setMessage("修改成功");
            messageBox.showMessage();
            empty();
        }else{
            messageBox.setMessage("修改失败");
            messageBox.showMessage();
        }
    }

    public void empty(){
        cname.setText("");
        cno.setText("");
        cex.setText("");
    }
    public void empty(ActionEvent actionEvent) {
    }

    public void find(ActionEvent actionEvent) {
        ResultSet rs = sqlHelper.executeQuery("SELECT * FROM "+username+"_COURSE WHERE CNO ='"+cno.getText()+"';");
        try {
            if(rs.next()){
                cname.setText(rs.getString("CNAME"));
                cex.setText(rs.getString("CREDIT"));
                cno.setText(rs.getString("CNO"));
            }
        } catch (SQLException throwables) {
            messageBox.setMessage("未找到该课程");
            messageBox.showMessage();
            throwables.printStackTrace();
        }
    }
}
