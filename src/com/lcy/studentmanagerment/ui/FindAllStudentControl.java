package com.lcy.studentmanagerment.ui;

import com.lcy.studentmanagerment.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Observable;

public class FindAllStudentControl extends BaseWindowControl {

    public TextField tName;
    public TextField tID;
    public TextField tDept;
    public ToggleGroup sex;
    public TableColumn cID;
    public TableColumn cName;
    public TableColumn cDept;
    public TableView table;
    public TableColumn cSex;
    private String stSex = "";

    public void find(ActionEvent actionEvent) {
        student.setName(tName.getText());
        student.setId(tID.getText());
        student.setDept(tDept.getText());
        student.setSex(stSex);
        ArrayList<Student> ans =  studentDao.find(student);
        ObservableList<Student> data = FXCollections.observableArrayList();
        for(Student st : ans){
            data.add(st);
        }
        cID.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        cDept.setCellValueFactory(new PropertyValueFactory<Student,String>("dept"));
        cSex.setCellValueFactory(new PropertyValueFactory<Student,String>("sex"));
        table.setItems(data);
    }

    public void female(ActionEvent actionEvent) {
        stSex = "女";
    }

    public void male(ActionEvent actionEvent) {
        stSex = "男";
    }
}
