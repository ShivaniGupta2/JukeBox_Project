package DAOImplClasses;

import DAOInterfaces.SongInterface;
import Model.Podcast;
import Model.Song;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Song_impl implements SongInterface {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Pass@123");
    Song obj1 = new Song();
    Scanner sc = new Scanner(System.in);

    public Song_impl() throws SQLException {
    }

    //PlaylistDetails_impl obj=new PlaylistDetails_impl();
    @Override
    public void insertNewSong() throws SQLException {
        System.out.println("Enter PlayListId");
        obj1.setPlaylist_id(sc.nextInt());
        System.out.println("*******************************");
        System.out.println("Enter New Song Details");
        System.out.println("*******************************");
        System.out.println("Enter Song Id");
        obj1.setS_id(sc.next());
        System.out.println("Enter Song Name");
        sc.nextLine();
        obj1.setS_name(sc.nextLine());
        System.out.println("Enter Song Genre");//Genre
        obj1.setS_genre(sc.next());
        System.out.println("Enter Singer Name");//Artist
        sc.nextLine();
        obj1.setS_artist(sc.nextLine());
        System.out.println("Enter Song Duration");
        obj1.setS_duration(Time.valueOf(sc.next()));
        System.out.println("Enter The Song Path");
        obj1.setS_Filepath(sc.next());
        System.out.println("********************************");
        System.out.println("* Song Added Successfully *");
        System.out.println("*********************************");

        String query = "insert into Song values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, obj1.getS_id());
        ps.setString(2, obj1.getS_name());
        ps.setString(3, obj1.getS_genre());
        ps.setString(4, obj1.getS_artist());
        ps.setTime(5, obj1.getS_duration());
        ps.setString(6, obj1.getS_Filepath());
        ps.setInt(7, obj1.getPlaylist_id());
        ps.executeUpdate();


    }

    @Override
    public List<Song> sortAllSongs(String sortCategory) {
        List<Song> list = displayAllSong();
        List<Song> songs = new ArrayList<>();
        switch (sortCategory) {
            case "name":
                songs = list.stream().sorted(Comparator.comparing(Song::getS_name)).collect(Collectors.toList());
                break;

            case "genre":
                songs = list.stream().sorted(Comparator.comparing(Song::getS_genre)).collect(Collectors.toList());
                break;

            case "artist":
                songs = list.stream().sorted(Comparator.comparing(Song::getS_artist)).collect(Collectors.toList());
                break;


        }

        return songs;
    }

    public List<Song> displayAllSong() {
        List<Song> list = new ArrayList<>();
//        System.out.println("Enter PlayListId");
//        int id=sc.nextInt();
        try {
            String query = "select * from Song";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String S_id = rs.getString(1);
                String S_name = rs.getString(2);
                String S_genre = rs.getString(3);
                String S_artist = rs.getString(4);
                Time S_duration = rs.getTime(5);
                String S_Filepath = rs.getString(6);
                int i = rs.getInt(7);
                Song obj = new Song(S_id, S_name, S_genre, S_artist, S_duration, S_Filepath, i);
                list.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;

    }

    public List<Song> seacrchByArtist(String name) {
        List<Song> list = displayAllSong();
        List<Song> res = list.stream().filter(v -> v.getS_artist().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (res.size() == 0) {
            System.out.println("Empty Song");
        }
        return res;
    }

    public List<Song> seacrchBySongId(String name) {
        List<Song> list = displayAllSong();
        List<Song> res = list.stream().filter(v -> v.getS_id().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (res.size() == 0) {
            System.out.println("Empty Song");
        }
        return res;
    }

    public List<Song> seacrchByGenere(String name) {

        List<Song> list = displayAllSong();
        List<Song> res = list.stream().filter(v -> v.getS_genre().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (res.size() == 0) {
            System.out.println("Empty Song");
            //return res;
        }

        return res;
    }
}