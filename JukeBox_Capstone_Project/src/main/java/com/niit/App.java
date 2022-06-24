package com.niit;


import DAOImplClasses.*;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws Exception {
        Scanner sc=new Scanner(System.in);
        User_impl obj=new User_impl();
        Song_impl song=new Song_impl();
        Playlist_impl podobj=new Playlist_impl();
        Podcast_impl p=new Podcast_impl();
        PlaylistDetails_impl p1=new PlaylistDetails_impl();

        System.out.println("*************************************  Welcome To My JukeBox Project   *************************************" );
        System.out.println("1.Are you existing User \n2.Create New Account ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("*****************************************");
                System.out.println("*           Please Login                *");
                System.out.println("*****************************************");
                p1.operation();
                break;

            case 2:
                obj.create_userid();
                System.out.println("***********************************");
                System.out.println("*       Please Login        *");
                System.out.println("************************************");
                p1.operation();
                break;

                default:
                System.out.println("Choose Correct Option");

        }




    }
}
