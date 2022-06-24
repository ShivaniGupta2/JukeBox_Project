package com.niit;
import DAOImplClasses.Podcast_impl;
import DAOImplClasses.User_impl;
import Model.Podcast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Podcast_implTest {

    Podcast_impl podcastobj=null;

    @BeforeEach
    public void setUp() throws SQLException {
        podcastobj=new Podcast_impl();
    }

    @AfterEach
    public void tearDown()
    {
        podcastobj=null;

    }
//    @Test
//    public void insertNewPodcastTest()
//    {
//        assertEquals();
//    }
    @Test
    public void sortAllPodcastTest1()
    {
        assertEquals(7,podcastobj.displayAllPodcast().size());
    }

    @Test
    public void sortAllPodCastTest2()
    {
        assertEquals("Sachin",podcastobj.sortAllPodcast("genre").get(4).getP_artist());
    }
    @Test
    public void displayAllPodcastTest3()
    {
        assertEquals(7,podcastobj.displayAllPodcast().size());
    }
    @Test
    public void displayAllPodcastTest4()
    {
        assertEquals("1",podcastobj.displayAllPodcast().get(3).getP_episode());

    }


}
