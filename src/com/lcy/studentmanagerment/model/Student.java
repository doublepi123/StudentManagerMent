package com.lcy.studentmanagerment.model;

public class Student {
    protected String name,id,sex;
    protected int age;
    protected String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return sex == "男";
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String s){
        sex = s;
    }
    public void setMale(boolean male) {
        if(male) sex = "男";
        else sex = "女";
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                '}';
    }

    public Student(String stID, String stName, int stAge, String stSex, String stDept){
        name = stName;
        id = stID;
        age = stAge;
        sex = stSex;
        dept = stDept;
    }
    public Student(){
    }
    public Student(String stID,String stName){
        name = stName;
        id = stID;
    }
}
