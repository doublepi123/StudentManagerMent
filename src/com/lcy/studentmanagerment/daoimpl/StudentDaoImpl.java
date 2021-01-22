package com.lcy.studentmanagerment.daoimpl;

import com.lcy.studentmanagerment.dao.StudentDao;
import com.lcy.studentmanagerment.model.Student;
import com.lcy.studentmanagerment.util.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    SQLHelper sqlHelper;
    String username;
    public StudentDaoImpl(String str){
        username = str;
        sqlHelper = new SQLHelper();
    }
    @Override
    public boolean add(Student st) {
        String sql = "INSERT INTO "+username+
                "_STUDENT VALUES('"+st.getId()+"','"
                +st.getName()
                +"','"+st.getSex()+
                "','"+st.getDept()+"');";
        System.out.println(sql);
        if(sqlHelper.executeUpdate(sql) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Student st) {
        String sql = "DELETE FROM "+username +
                "_STUDENT WHERE SNO = '"+st.getId()+"';";
        if(sqlHelper.executeUpdate(sql) > 0) return true;
        return false;
    }

    @Override
    public Student find(String id) {
        Student student = null;
        String sql = "SELECT * FROM "+
                username+"_STUDENT WHERE SNO ='"+id+"';";
        ResultSet rs =  sqlHelper.executeQuery(sql);
        try {
            if(rs.next()){
                student = new Student();
                student.setId(rs.getString("SNO"));
                student.setName(rs.getString("SNAME"));
                student.setDept(rs.getString("SDEPT"));
                student.setSex(rs.getString("SEX"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public ArrayList<Student> find(Student st) {
        ArrayList<Student> ans = new ArrayList<>();
        String sql = "SELECT * FROM "+
                username+"_STUDENT WHERE 1=1 ";
        sql += "AND SNO LIKE '%"+st.getId()+"%'";
        sql += "AND SNAME LIKE '%"+st.getName()+"%'";
        sql += "AND SDEPT LIKE '%"+st.getDept()+"%'";
        sql += "AND SEX LIKE '%"+st.getSex()+"%'";
        ResultSet rs =  sqlHelper.executeQuery(sql);
        Student student = new Student();
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ans.add(new Student(rs.getString("SNO"),
                        rs.getString("SNAME"),
                        0,rs.getString("SEX"),
                        rs.getString("SDEPT")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return ans;
    }

    @Override
    public boolean update(Student st) {
        if(st == null) return false;
        sqlHelper.executeUpdate("UPDATE "+username+"_STUDENT SET SNAME = '"+
                st.getName()+"' WHERE SNO = '"+st.getId()+"';");
        sqlHelper.executeUpdate("UPDATE "+username+"_STUDENT SET SEX = '"+
                st.getSex()+"' WHERE SNO = '"+st.getId()+"';");
        sqlHelper.executeUpdate("UPDATE "+username+"_STUDENT SET SDEPT = '"+
                st.getDept()+"' WHERE SNO = '"+st.getDept()+"';");
        return true;
    }
}
