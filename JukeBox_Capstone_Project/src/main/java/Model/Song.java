package Model;

import java.sql.Time;

public class Song
{
  private String S_id;
  private String S_name;
  private String S_genre;
  private String S_artist;
  private Time S_duration;
  private String S_Filepath;
  private  int Playlist_id;

  public Song(String s_id, String s_name, String s_genre, String s_artist, Time s_duration, String s_Filepath, int playlist_id) {
    S_id = s_id;
    S_name = s_name;
    S_genre = s_genre;
    S_artist = s_artist;
    S_duration = s_duration;
    S_Filepath = s_Filepath;
    Playlist_id = playlist_id;
  }

  public Song() {
  }

  public String getS_id() {
    return S_id;
  }

  public void setS_id(String s_id) {
    S_id = s_id;
  }

  public String getS_name() {
    return S_name;
  }

  public void setS_name(String s_name) {
    S_name = s_name;
  }

  public String getS_genre() {
    return S_genre;
  }

  public void setS_genre(String s_genre) {
    S_genre = s_genre;
  }

  public String getS_artist() {
    return S_artist;
  }

  public void setS_artist(String s_artist) {
    S_artist = s_artist;
  }

  public Time getS_duration() {
    return S_duration;
  }

  public void setS_duration(Time s_duration) {
    S_duration = s_duration;
  }

  public String getS_Filepath() {
    return S_Filepath;
  }

  public void setS_Filepath(String s_Filepath) {
    S_Filepath = s_Filepath;
  }

  public int getPlaylist_id() {
    return Playlist_id;
  }

  public void setPlaylist_id(int playlist_id) {
    Playlist_id = playlist_id;
  }

  @Override
  public String toString() {
    return "Song{" +
            "S_id='" + S_id + '\'' +
            ", S_name='" + S_name + '\'' +
            ", S_genre='" + S_genre + '\'' +
            ", S_artist='" + S_artist + '\'' +
            ", S_duration=" + S_duration +
            ", S_Filepath='" + S_Filepath + '\'' +
            ", Playlist_id=" + Playlist_id +
            '}';
  }
}

