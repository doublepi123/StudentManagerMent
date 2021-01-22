package com.lcy.studentmanagerment.util;

import java.sql.*;

public class SQLHelper {
    private static final String Driver="com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://sh.gxu.icu:3306/studentmanagerment?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private Connection conn = null;
    private Statement stmt = null;

    public SQLHelper() {
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(url,"studentmanagerment","lcyzuishuai");
            stmt = conn.createStatement();                            //创建语句
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;

    }

    public int executeUpdate(String sql){
        int res = 0;
        try {
            res = stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    public void close() throws SQLException {
        stmt.close();
        conn.close();
    }
}
