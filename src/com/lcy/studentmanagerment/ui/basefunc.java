package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.util.SQLHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class basefunc {
    protected static SQLHelper sqlHelper;
    protected String username;
    protected static MessageBox messageBox;
    protected Stage stage;
    public Button bAdd;
    protected boolean isInit;
    public void init(String s) throws IOException {
        if(isInit) return;
        isInit = true;
        sqlHelper = new SQLHelper();
        messageBox = new MessageBox();
        stage = (Stage)bAdd.getScene().getWindow();
        username = s;
    }
    public void quit(ActionEvent actionEvent) {
        stage.close();
    }
}
