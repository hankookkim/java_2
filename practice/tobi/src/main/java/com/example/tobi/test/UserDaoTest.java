package com.example.tobi.test;

import com.example.tobi.dao.ConnectionMaker;
import com.example.tobi.dao.DConnectionMaker;
import com.example.tobi.dao.NConnectionMaker;
import com.example.tobi.dao.UserDao;
import com.example.tobi.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
//        ConnectionMaker connectionMaker = new NConnectionMaker();

        UserDao dao = new UserDao(connectionMaker);

        User user =new User();
        user.setId("whiteship");
        user.setName("김한국");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId()+"등록성공");

        User user2 =dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId()+"조회성공");

    }
}
