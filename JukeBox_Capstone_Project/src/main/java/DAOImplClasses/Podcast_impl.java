package DAOImplClasses;

import DAOInterfaces.PodcastInterface;
import Model.Podcast;
import Model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Podcast_impl implements PodcastInterface {

    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Pass@123");

    Podcast podcastobj=new Podcast();
    //Podcast obj2 = new Podcast();
    Scanner sc=new Scanner(System.in);

    public Podcast_impl() throws SQLException {
    }

    @Override
    public void insertNewPodcast() throws Exception {
        System.out.println("Enter PlayListId");
        podcastobj.setPlaylist_id(sc.nextInt());
        System.out.println("*********************************");
        System.out.println("Enter New Podcast Details");
        System.out.println("*********************************");
        System.out.println("Enter Podcast ID");
        podcastobj.setP_id(sc.next());
        System.out.println("Enter Podcast Genre");
        podcastobj.setP_genre(sc.next());
        System.out.println("Enter Podcast Artist");
        podcastobj.setP_artist(sc.next());
        System.out.println("Enter Episode");
        podcastobj.setP_episode(sc.next());
        System.out.println("Enter Episode Release Date");
       //podcastobj.setReleasedate(Date.valueOf(sc.next()));
        podcastobj.setReleasedate(Date.valueOf(sc.next()));
        System.out.println("Enter Podcast Path");
        podcastobj.setFilepath(sc.next());
        System.out.println("******************************");
        System.out.println("* Podcast Added Successfully *");
        System.out.println("******************************");

        String query="insert into Podcast values(?,?,?,?,?,?,?)";
        PreparedStatement pus= con.prepareStatement(query);
        pus.setString(1,podcastobj.getP_id());
        pus.setString(2,podcastobj.getP_genre());
        pus.setString(3, podcastobj.getP_artist());
        pus.setString(4, podcastobj.getP_episode());
        pus.setDate(5, podcastobj.getReleasedate());
        pus.setString(6,podcastobj.getFilepath());
        pus.setInt(7,podcastobj.getPlaylist_id());
        pus.executeUpdate();

    }

    @Override
    public List<Podcast> sortAllPodcast(String sortCategory)
    {   List<Podcast> list=displayAllPodcast();
        List<Podcast> pod=new ArrayList<>();
        switch (sortCategory)
        {


            case "genre":
                pod= list.stream().sorted(Comparator.comparing(Podcast::getP_genre)).collect(Collectors.toList());
                break;

            case "artist":
                pod=list.stream().sorted(Comparator.comparing(Podcast::getP_artist)).collect(Collectors.toList());
                break;


        }

        return pod;
    }

    public List<Podcast> displayAllPodcast()
    {

        List<Podcast> list1=new ArrayList<>();

        try{
            String query1="select * from Podcast";
            Statement st=con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            while(rs1.next())
            {
                String P_id=rs1.getString(1);
                String P_genre=rs1.getString(2);
                String P_artist=rs1.getString(3);
                String P_episode=rs1.getString(4);
                Date releasedate=rs1.getDate(5);
                String P_Filepath=rs1.getString(6);
                int j= rs1.getInt(7);
                Podcast obj2=new Podcast(P_id,P_genre,P_artist,P_episode,releasedate,P_Filepath,j);
                list1.add(obj2);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list1;


    }
}
