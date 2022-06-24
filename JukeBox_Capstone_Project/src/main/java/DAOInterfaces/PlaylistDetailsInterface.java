package DAOInterfaces;

import Model.Podcast;
import Model.Song;

import java.sql.SQLException;
import java.util.List;

public interface PlaylistDetailsInterface {

    public void operation() throws Exception;
    public void readAudio(String audioSrcFile, int count);
    public void displayPlayListSong() throws SQLException;

    public  void displayPlayListPodcast() throws SQLException;

}
