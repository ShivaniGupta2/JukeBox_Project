package DAOImplClasses;

import DAOInterfaces.PlaylistDetailsInterface;
import Model.Podcast;
import Model.Song;
import com.niit.PlayAudio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlaylistDetails_impl implements PlaylistDetailsInterface {

    Scanner sc = new Scanner(System.in);
    //User_impl obj=new User_impl()
    Song_impl song = new Song_impl();
    Playlist_impl podobj = new Playlist_impl();
    Podcast_impl p = new Podcast_impl();
    Podcast_impl ob = new Podcast_impl();

   // List<Song> list = new ArrayList<>();
    List<Podcast> list1 = new ArrayList<>();
    //int user;
    String p1;
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Pass@123");
    User_impl obj=new User_impl();
    public PlaylistDetails_impl() throws SQLException {
    }

    @Override
    public void operation() throws Exception {

        System.out.println("Enter Your UserId");
        int id = sc.nextInt();
        System.out.println("Enter password");
        String pass = sc.next();

        if (obj.loginUser(id,pass)==true) {
            System.out.println("************************");
            System.out.println("login successfully");
            while (true) {
                System.out.println("********************" +
                        "\n1. Create PlayList " +
                        "\n2. Add Song in PlayList " +
                        "\n3. Add Podcast in PlayList " +
                        "\n4. Delete PlayList " +
                        "\n5. Display All Song / Podcast From Playlist " +
                        "\n6. Display After Sorting " +
                        "\n7. Search Song "+
                        "\n8. View Playlist "+
                        "\n9. Play Playlist  " +
                        "\n10. Exit " +
                        "\n********************");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        podobj.createPlaylist();
                        break;
                    case 2:
                        song.insertNewSong();
                        break;
                    case 3:
                        p.insertNewPodcast();
                        break;
                    case 4:
                        podobj.deletePlaylist();
                        break;
                    case 5:
                        System.out.println("Choose Display \n1.Song \n2.PodCast");
                        int c = sc.nextInt();
                        if (c == 1) {
                            List<Song> S =song.displayAllSong();
                            S.forEach(x -> System.out.println(x));
                        }
                        if (c == 2) {
                            List<Podcast> P =p.displayAllPodcast();
                            P.forEach(x -> System.out.println(x));

                        }
                        break;
                    case 6:
                        System.out.println("  \n1.Sorted Songs list\n2.Sorted Podcast list  ");
                        int i1 = sc.nextInt();
                        if (i1 == 1) {

                            System.out.println("Enter Category");//Genre- Jazz,Rock,Melody
                            String cat = sc.next().toLowerCase();

                            List<Song> srt = song.sortAllSongs(cat);
                            for (Song x : srt) {
                                System.out.println(x);
                            }
                        }
                        if (i1 == 2) {

                            System.out.println("Enter Category");
                            String cat1 = sc.next().toLowerCase();

                            List<Podcast> prt = ob.sortAllPodcast(cat1);
                            for (Podcast x : prt) {
                                System.out.println(x);
                            }
                        }
                        break;
                    case 7:
                        System.out.println("search on the basis of \n1.Artist \n2.SongID \n3.Genre");
                        int j=sc.nextInt();
                        if(j==1)
                        {
                            System.out.println("Enter Artist Name");
                            sc.nextLine();
                            String artist=sc.nextLine();
                            song.seacrchByArtist(artist).forEach(x-> System.out.println(x));
                        }
                        if(j==2)
                        {
                            System.out.println("Enter SongId ");
                            String sid=sc.next();
                            song.seacrchBySongId(sid).forEach(x-> System.out.println(x));
                        }
                        if(j==3)
                        {
                            System.out.println("Enter genre category");
                            String cate=sc.next();
                            song.seacrchByGenere(cate).forEach(x-> System.out.println(x));
                        }
                        break;
                    case 8:

                        //displayPlayList();
                        System.out.println("Choose \n1.Display Song PlayList  \n2.Display Podcast Playlist");
                        int d=sc.nextInt();
                        if(d==1)
                        {
                            displayPlayListSong();
                        }
                        if(d==2)
                        {
                            displayPlayListPodcast();
                        }
                        break;
                    case 9:
                        System.out.println("----------------------------------------------");
                        System.out.println("*   Choose which you want to listen   *" +
                                "\n1.Song " +
                                "\n2.Podcast ");
                        int chc = sc.nextInt();
                        if (chc == 1) {
                            String songpath = "";
//                            System.out.println("*** Enter SongId Which You Want To Play ***");
//                            String sid = sc.next();
                            String query8 = "select S_Filepath from song";
                            Statement stt5 = con.createStatement();
                            ResultSet rur = stt5.executeQuery(query8);
                            while (rur.next()) {

                                songpath = rur.getString("S_FilePath");
                                readAudio(songpath, 1);
                            }

                        }
                        if (chc == 2) {
                            String path1 = "";
//                            System.out.println("*** Enter PodcastId Which You Want To Play ***");
//                            String pid = sc.next();
                            String query3 = "select P_Filepath from podcast";
                            Statement stt2 = con.createStatement();
                            ResultSet rr3 = stt2.executeQuery(query3);
                            while (rr3.next()) {
                                path1 = rr3.getString("P_Filepath");
                                readAudio(path1,1);
                            }

                        }

                        break;
                    case 10:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Choose correct Option");
                }

            }
        } else {
            System.out.println("User Id and Password Not match. Please Login Again");
            operation();
        }

    }



    public void readAudio(String audioSrcFile, int count) {

        PlayAudio playAudio = new PlayAudio();
        int c = 0;
        count = count - 1;
        try {

            playAudio.playAudio1(audioSrcFile, count);

            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {

                System.out.println("*************************");

                System.out.println("        <<  ||   >>     ");
                System.out.println("        1. pause        ");
                System.out.println("        2. resume       ");
                System.out.println("        3.restart       ");
                System.out.println("        4.Stop        ");


                System.out.println("***************************");
                if (c == 4) {
                    break;
                }

                if (scanner.hasNextInt()) {
                    c = scanner.nextInt();
                } else {
                    break;
                }
                switch (c) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;


                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }

    public void displayPlayListSong() throws SQLException {
//        String query="select playlist.playlist_id,playlist.Playlist_name,song.s_Id,song.s_name,song.s_genre,song.s_artist,podcast.p_id,podcast.p_artist from playlist  inner join" +
//                " song on playlist.playlist_id=song.playlist_id inner join podcast on playlist.playlist_id=podcast.playlist_id";

        String qw="select song.s_Id,song.s_name,song.s_genre,song.s_artist,playlist.playlist_id,playlist.Playlist_name from song inner join playlist where song.playlist_id=playlist.playlist_id";


        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(qw);
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getString(6));

        }


    }

   public void displayPlayListPodcast() throws SQLException {
        String qw="select podcast.p_id,podcast.p_genre,podcast.p_artist,podcast.p_episode,playlist.playlist_id,playlist.Playlist_name from podcast inner join playlist where podcast.playlist_id=playlist.playlist_id";



        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(qw);
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getString(6));

        }
    }


}
