package DAOInterfaces;

import Model.Playlist;

import java.sql.SQLException;
import java.util.List;

public interface PlaylistInterface {
    public void createPlaylist() throws SQLException;

    public void deletePlaylist() throws SQLException;




}
