package com.lcy.studentmanagerment.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessageBoxControl {
    public Button tExit;
    public Text tMessage;

    public void exit(ActionEvent actionEvent) {
        ((Stage) tExit.getScene().getWindow()).close();
    }

    public void init(String s){
        tMessage.setText(s);
        tExit.setText("确定");
    }
}
