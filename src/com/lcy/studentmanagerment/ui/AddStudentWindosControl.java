package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.util.SQLHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddStudentWindosControl {
    Stage stage;
    public TextField sdept;
    private String username;
    static SQLHelper sqlHelper;
    static MessageBox messageBox;
    public Button bAdd;
    public Button bQuit;
    public Button bEmpty;
    public TextField sno;
    public TextField sname;
    public TextField sex;
    boolean isInit;
    void init(String s) throws IOException {
        if(isInit) return;
        isInit = true;
        sqlHelper = new SQLHelper();
        messageBox = new MessageBox();
        stage = (Stage)bAdd.getScene().getWindow();
        username = s;
    }
    public void add(ActionEvent actionEvent) {
        if(sqlHelper.executeUpdate(
                "INSERT INTO "+username+
                "_STUDENT VALUES('"+sno.getText()+"','"
                +sname.getText()
                +"','"+sex.getText()+
                "','"+sdept.getText()+"');"
        ) == 1) {
            messageBox.setMessage("添加成功！");
            messageBox.showMessage();
            empty();
        }
        else{
            messageBox.setMessage("添加失败！");
            messageBox.showMessage();
        }
    }

    public void quit(ActionEvent actionEvent) {
        stage.close();
    }

    public void empty(ActionEvent actionEvent) {
        empty();
    }
    private void empty(){
        sno.setText("");
        sname.setText("");
        sex.setText("");
        sdept.setText("");
        return;
    }
}
