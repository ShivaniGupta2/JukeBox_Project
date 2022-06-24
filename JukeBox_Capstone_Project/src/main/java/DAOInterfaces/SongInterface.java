package DAOInterfaces;

import Model.Song;

import java.sql.SQLException;
import java.util.List;

public interface SongInterface
{

    public void insertNewSong() throws SQLException;
    List<Song> sortAllSongs(String sortCategory);

    List<Song> displayAllSong();
    public List<Song> seacrchByArtist(String name);
    public List<Song> seacrchBySongId(String name);
    public List<Song> seacrchByGenere(String name);

}
