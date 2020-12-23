package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.util.SQLHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCourseControl {

    public TextField cno;
    public TextField cname;
    public TextField cex;
    public Button bAdd;
    public Button bQuit;
    public Button bEmpty;
    private boolean isInit;
    static SQLHelper sqlHelper;
    static MessageBox messageBox;
    private Stage stage;
    String username;
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
                        "_Course VALUES('"+cno.getText()+"','"
                        +cname.getText()
                        + "',"+cex.getText()+");"
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

    }
    private void empty(){
        cex.setText("");
        cname.setText("");
        cno.setText("");
    }
}
