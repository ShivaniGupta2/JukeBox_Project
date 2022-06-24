package Model;

public class User
{
    private int user_id;
    private String user_password;
    private long Mobileno;

    public User(int user_id, String user_password, long mobileno) {
        this.user_id = user_id;
        this.user_password = user_password;
        Mobileno = mobileno;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public long getMobileno() {
        return Mobileno;
    }

    public void setMobileno(long mobileno) {
        Mobileno = mobileno;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_password='" + user_password + '\'' +
                ", Mobileno=" + Mobileno +
                '}';
    }
}

