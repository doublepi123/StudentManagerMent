package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.util.SQLHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginWindowControl {
    public Button bLogin;
    public PasswordField tPassword;
    public TextField tUsername;
    public Button bSubmission;
    static SQLHelper sqlHelper;
    Stage primaryStage;
    boolean check(){
        if(tPassword.getText().isEmpty() || tUsername.getText().isEmpty()){
            return false;
        }
        return true;
    }
    private boolean isInit;
    private MessageBox messageBox;
    void init() throws IOException {
        if(sqlHelper == null) sqlHelper = new SQLHelper();
        messageBox = new MessageBox();
        primaryStage = (Stage) bLogin.getScene().getWindow();
        sqlHelper.executeUpdate("CREATE TABLE IF NOT EXISTS USER(USERNAME VARCHAR(20) PRIMARY KEY,PASSWORD VARCHAR(10));");
    }
    private boolean checkUsernameAndPassword(){
        String password = "";
        ResultSet rs = sqlHelper.executeQuery("SELECT PASSWORD FROM USER WHERE USERNAME = '"+tUsername.getText()+ "';");
        try {
            if(rs.next()) password = rs.getString(1);
        } catch (SQLException throwables) {
            messageBox.setMessage("用户名不存在！！！");
            messageBox.showMessage();
            throwables.printStackTrace();
            return false;
        }
        if(password.equals(tPassword.getText())) return true;
        messageBox.setMessage("用户名或密码错误！！！");
        messageBox.showMessage();
        return false;
    }
    public void Login(ActionEvent actionEvent) throws IOException, SQLException {
        if(isInit == false) init();
        if(!check()){
            messageBox.setMessage("您输入的信息有误！");
            messageBox.showMessage();
            return;
        }
        if(!checkUsernameAndPassword()){
            messageBox.setMessage("用户名或密码错误！");
            messageBox.showMessage();
            return;
        }
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        stage.setScene(new Scene(loader.load()));
        MainWindowControl mainWindowControl  = loader.getController();
        mainWindowControl.init(tUsername.getText());
        stage.setTitle("学生信息管理系统");
        stage.show();
        sqlHelper.close();
        primaryStage.close();
    }

    public void submission(ActionEvent actionEvent) throws IOException {
        if(isInit == false) init();
        if(!check()){
            messageBox.setMessage("您输入的信息有误！");
            messageBox.showMessage();
        }
        if(sqlHelper.executeUpdate("INSERT INTO USER VALUES('"+tUsername.getText()+"','"+tPassword.getText()+"');") == 1){messageBox.setMessage("您输入的信息有误！");
            messageBox.setMessage("注册成功！");
            messageBox.showMessage();
            sqlHelper.executeUpdate("CREATE TABLE "+tUsername.getText()+"_STUDENT (SNO CHAR(12) PRIMARY KEY,SNAME VARCHAR(20),SEX CHAR(4), SDEPT VARCHAR(30));");
            sqlHelper.executeUpdate("CREATE TABLE "+tUsername.getText()+"_COURSE (CNO CHAR(12) PRIMARY KEY,CNAME VARCHAR(20),CREDIT INT);");
            sqlHelper.executeUpdate("CREATE TABLE "+tUsername.getText()+"_SC (SNO CHAR(12),CNO CHAR(12), GRADE INT,PRIMARY KEY(SNO,CNO),foreign key (Sno) references Student(Sno)," +
                    "foreign key (Cno) references Course(Cno));");

        }else{
            messageBox.setMessage("注册失败！");
            messageBox.showMessage();
        }
    }
}
