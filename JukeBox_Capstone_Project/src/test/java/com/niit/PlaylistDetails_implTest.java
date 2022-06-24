package com.niit;

import DAOImplClasses.PlaylistDetails_impl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistDetails_implTest {

    PlaylistDetails_impl podobj=null;

    @BeforeEach
    public void setUp() throws SQLException
    {
        podobj=new PlaylistDetails_impl();
    }

    @AfterEach
    public void tearDown()
    {
        podobj=null;
    }

    @Test
    public void operation()
    {
        //assertEquals();
    }
}

