package com.example.tobi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{


    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/java2_basic?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8","root","1234");
        return c;  //D사의 독자적인 방법의 예시
    }
}
