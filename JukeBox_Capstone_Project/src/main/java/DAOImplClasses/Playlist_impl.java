package DAOImplClasses;

import DAOInterfaces.PlaylistInterface;
import Model.Playlist;
import Model.Podcast;
import Model.Song;


import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Playlist_impl implements PlaylistInterface
{
    Scanner sc=new Scanner(System.in);
    Playlist p=new Playlist();

    Song s=new Song();

    Podcast pp=new Podcast();
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Pass@123");

    Playlist obj=new Playlist();
    public Playlist_impl() throws SQLException {
    }

    @Override
    public void createPlaylist() throws SQLException {
        System.out.println("*******************************");
        System.out.println("    Create New PlayList     ");
        System.out.println("******************************");
        System.out.println("Enter Your UserId");
        p.setUser_id(sc.nextInt());
        System.out.println("Enter PlayListId");
        p.setPlaylist_id(sc.nextInt());
        System.out.println("Enter PlayList Name");
        p.setPlaylist_name(sc.next());
        System.out.println("**********************************************************");
        System.out.println("*    Your Playlist Has Been Created Successfully     *");
        System.out.println("**********************************************************");
        System.out.println();

        String q="insert into Playlist values(?,?,?)";
        PreparedStatement ps= con.prepareStatement(q);
        ps.setInt(2,p.getPlaylist_id());
        ps.setInt(1,p.getUser_id());
        ps.setString(3,p.getPlaylist_name());
        ps.executeUpdate();

    }

    @Override
    public void deletePlaylist() throws SQLException {

        System.out.println("Enter Your PlaylistId");
        p.setPlaylist_id(sc.nextInt());
        System.out.println("Choose option \n1. Delete Playlist Songs \n2. Delete Playlist Podcast");
        int choice= sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter Your SongId which You want to delete");
                s.setS_id(sc.next());
                String del = "delete from song where S_id="+"'"+s.getS_id()+"'"+" and Playlist_id="+p.getPlaylist_id();
                Statement st= con.createStatement();
                st.executeUpdate(del);
                System.out.println("* Your Song Has Been Deleted Successfully *");
                break;

            case 2:
                System.out.println("Enter PodcastId which you want to delete From PlayList");
                pp.setP_id(sc.next());
                String del1="delete from Podcast where P_id="+"'"+pp.getP_id()+"'"+"and Playlist_id="+p.getPlaylist_id();
                Statement st1= con.createStatement();
                st1.executeUpdate(del1);
                System.out.println("************************************************");
                System.out.println("* Your Podcast Has Been Deleted Successfully *");
                System.out.println("*************************************************");
                break;
            default:
                System.out.println("Choose another option");



        }



    }


}

