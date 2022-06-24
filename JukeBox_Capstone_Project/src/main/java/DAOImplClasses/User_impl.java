package DAOImplClasses;

import DAOInterfaces.UserInterface;
import Model.User;



import java.sql.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User_impl implements UserInterface {

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Pass@123");

    Scanner sc = new Scanner(System.in);
    User ob = new User();

    public User_impl() throws SQLException {
    }


    // @Override
    public void create_userid() {


        try {
         //   System.out.println("----------------------------------------------");
            getUserId();
            getMobileNo();
            getPassword();
            System.out.println("-------------------------------------------------");
            System.out.println(" *           Confirm Password                   *");
            System.out.println("--------------------------------------------------");
            String pass1 = sc.next();
         //   System.out.println("Your Account has been Created successfully");

            if (ob.getUser_password().equals(pass1)) {
                String query1 = "insert into User values(?,?,?)";
                PreparedStatement pus = con.prepareStatement(query1);
                pus.setInt(1, ob.getUser_id());
                pus.setString(2, ob.getUser_password());
                pus.setLong(3, ob.getMobileno());
                pus.executeUpdate();
                System.out.println("***************************************************************");
                System.out.println("            Your Account has been Created successfully          ");
                System.out.println("****************************************************************");
            } else {
                System.out.println("Password Not match.Please Re-Enter Your Details");
                create_userid();
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }
        public void getUserId()
        {
            System.out.println("----------------------------------------------");
            System.out.println(" *           Create Your User ID            *");
            System.out.println("-----------------------------------------------");
            int  user=sc.nextInt();
            String  str="^[0-9]{4}$";
            Pattern p=Pattern.compile(str);
            Matcher m=p.matcher(String.valueOf(user));
            if(m.matches())
            {
                ob.setUser_id(user);
            }
            else {
                System.out.println("UserId is not in valid Format");
               // create_userid();
                getUserId();
            }
        }
        public void getMobileNo()
        {
            System.out.println("------------------------------------------------");
            System.out.println(" *           Enter Your MobileNo            *   ");
            System.out.println("-------------------------------------------------");
            long mob=sc.nextLong();
            String reg="^[0-9]{10}$";
            Pattern p1=Pattern.compile(reg);
            Matcher m1=p1.matcher(String.valueOf(mob));
            if (m1.matches())
            {
                ob.setMobileno(mob);
            }
            else {
                System.out.println("Invalid Mobile Number Format");
               // create_userid();
                getMobileNo();
            }
        }
        public void getPassword()
        {
            System.out.println("--------------------------------------------------");
            System.out.println("  *          Enter Your Password                 *  ");
            System.out.println("-------------------------------------------------");
            String pass=sc.next();
            String regex = "^(?=.*[a-z])(?=."
                    + "*[A-Z])(?=.*\\d)"
                    + "(?=.*[-+_!@#$%^&*., ?]).+$";
            Pattern p2 = Pattern.compile(regex);
            Matcher m2=p2.matcher(pass);
            if(m2.matches())
            {
                ob.setUser_password(pass);}
            else {
                System.out.println("Password must contain one lower letter,one upper case,one number and one symbol");
                //create_userid();
                getPassword();
            }
        }

    public void editUserProfile() throws SQLException {
        System.out.println("Enter Your User_Id");
        String id = sc.next();
        System.out.println("Choose Option \n1.Change password \n 2.Change MobileNo");
        int choice = sc.nextInt();
        switch (choice)
         {
             case 1:
            System.out.println("Enter New Password");
            ob.setUser_password(sc.next());
            System.out.println("Confirm Password");
            String pass = sc.next();
            if (ob.getUser_password().equals(pass)) {
                String query = "update user set User_password=" + "'" + pass + "'" + " where User_id=" + id;
                Statement st = con.createStatement();
                st.executeUpdate(query);

            } else {
                System.out.println("*    Password Not Match .Try Again      *");
                editUserProfile();
            }
            break;
             case 2:
                System.out.println("Enter New MobileNo");
                ob.setMobileno(sc.nextLong());
                System.out.println("ReEnter MobileNo");
                long mobile = sc.nextLong();
                if (ob.getMobileno() == mobile) {
                    String q = "Update user set User_mobileNo=" + mobile + " where User_id=" + id;
                    Statement st = con.createStatement();
                    st.executeUpdate(q);
                } else {
                    System.out.println("*   Mobile Number Not match. Please Try Again   *");
                    editUserProfile();
                }
                break;
             default:
                 System.out.println("Choose Correct Option");
            }

        }


        public boolean loginUser(int userId,String password) throws SQLException {
            PreparedStatement ps = con.prepareStatement("select * from user where user_id=? and user_password=? ");
            ps.setInt(1,userId);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                rs.close();
                ps.close();
                return true;
            }
            rs.close();
            ps.close();


            return false;
        }
    }








