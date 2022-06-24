package Model;


import java.sql.Date;

public class Podcast
{
    private  String P_id;
    private  String P_genre;
    private  String P_artist;
    private  String P_episode;
    private Date releasedate;
    private  String filepath;
    private int  playlist_id;

    public Podcast(String p_id, String p_genre, String p_artist, String p_episode, Date releasedate, String filepath, int playlist_id) {
        P_id = p_id;
        P_genre = p_genre;
        P_artist = p_artist;
        P_episode = p_episode;
        this.releasedate = releasedate;
        this.filepath = filepath;
        this.playlist_id = playlist_id;
    }

    public Podcast() {

    }

    public String getP_id() {
        return P_id;
    }

    public void setP_id(String p_id) {
        P_id = p_id;
    }

    public String getP_genre() {
        return P_genre;
    }

    public void setP_genre(String p_genre) {
        P_genre = p_genre;
    }

    public String getP_artist() {
        return P_artist;
    }

    public void setP_artist(String p_artist) {
        P_artist = p_artist;
    }

    public String getP_episode() {
        return P_episode;
    }

    public void setP_episode(String p_episode) {
        P_episode = p_episode;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "P_id='" + P_id + '\'' +
                ", P_genre='" + P_genre + '\'' +
                ", P_artist='" + P_artist + '\'' +
                ", P_episode='" + P_episode + '\'' +
                ", releasedate=" + releasedate +
                ", filepath='" + filepath + '\'' +
                ", playlist_id=" + playlist_id +
                '}';
    }
}
