package DAOInterfaces;

import Model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserInterface
{
   public void create_userid();
   public void getUserId();
   public void getMobileNo();
   public void getPassword();
   public void editUserProfile() throws SQLException;
}
