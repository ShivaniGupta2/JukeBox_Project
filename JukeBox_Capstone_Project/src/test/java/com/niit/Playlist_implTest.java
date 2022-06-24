package com.niit;
import DAOImplClasses.PlaylistDetails_impl;
import DAOImplClasses.Playlist_impl;
import DAOImplClasses.Podcast_impl;
import DAOImplClasses.User_impl;
import Model.Podcast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Playlist_implTest {

    Playlist_impl p=null;

    @BeforeEach
    public void setUp() throws SQLException
        {
            p=new Playlist_impl();
        }
    @AfterEach
    public void tearDown()
    {
        p=null;
    }
    @Test
    public void  createPlaylist()
    {
      //  assertEquals();
    }
    @Test
    public void deletePlaylist()
    {
       // assertEquals();
    }
}
