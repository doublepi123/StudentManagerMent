package com.lcy.studentmanagerment.dao;

import com.lcy.studentmanagerment.model.Student;

import java.util.ArrayList;

public interface StudentDao {
    boolean add(Student st);
    boolean delete(Student st);
    Student find(String id);
    ArrayList <Student> find(Student st);
    boolean update(Student st);
}
