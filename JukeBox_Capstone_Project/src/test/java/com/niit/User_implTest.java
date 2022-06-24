package com.niit;
import DAOImplClasses.Podcast_impl;
import DAOImplClasses.User_impl;
import Model.Podcast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_implTest {
    User_impl ob=null;


    @BeforeEach
    public void setUp() throws  SQLException{
        ob= new User_impl();
    }
    @AfterEach
    public void tearDown()
    {
       ob=null;
    }

    @Test
    public void loginUserTest() throws SQLException {
        assertEquals(true,ob.loginUser(8080,"Shivu8080"));
    }

    @Test
    public void loginUserTest2() throws SQLException {
       assertEquals(false,ob.loginUser(666,"Shivani"));
    }
}
