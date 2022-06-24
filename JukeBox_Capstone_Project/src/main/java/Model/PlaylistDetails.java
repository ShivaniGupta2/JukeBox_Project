package Model;

public class PlaylistDetails
{
    private int playlist_id;
    private String S_id;
    private String P_id;

    public PlaylistDetails(int playlist_id, String s_id, String p_id) {
        this.playlist_id = playlist_id;
        S_id = s_id;
        P_id = p_id;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getS_id() {
        return S_id;
    }

    public void setS_id(String s_id) {
        S_id = s_id;
    }

    public String getP_id() {
        return P_id;
    }

    public void setP_id(String p_id) {
        P_id = p_id;
    }
}
