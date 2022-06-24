package com.niit;
import DAOImplClasses.Song_impl;
import Model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Song_implTest {

    Song_impl obj=null;

    //List<Song> list=obj.sortAllSongs(new ArrayList<>(),"genre");

    @BeforeEach
    public void setUp() throws SQLException {
        obj=new Song_impl();
    }
    @AfterEach
    public void tearDown()
    {
        obj=null;
    }

    @Test
    public void displayAllSongTest()
    {
        assertEquals(4,obj.displayAllSong().size());       ;
    }

    @Test
    public void diplayAllSongTest1()
    {
       assertEquals("Raata lambiya",obj.displayAllSong().get(2).getS_name());

    }

    @Test
    public void sortAllSongTest2()
    {
       assertEquals("Kesariya",obj.sortAllSongs("genre").get(1).getS_name());
    }
}
