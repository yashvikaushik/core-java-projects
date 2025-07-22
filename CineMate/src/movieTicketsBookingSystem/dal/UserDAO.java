package movieTicketsBookingSystem.dal;
import movieTicketsBookingSystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movieTicketsBookingSystem.dal.DBConnection;


public class UserDAO {
    User user;
    //DBConnection connection=new DBConnection(); (not requires static method)
    Connection conn=DBConnection.getConnection();
    public boolean registerUser(User user){
        String template="INSERT INTO users(name,email,password) VALUES (?,?,?);";
        try(PreparedStatement psmt= conn.prepareStatement(template)){
            psmt.setString(1, user.getUserName());
            psmt.setString(2, user.getEmail());
            psmt.setString(3, user.getPassword());
            int rowsUpdated=psmt.executeUpdate();
            return true;
        }
        catch(SQLException se){
            System.out.println(se);
        }
        return false;

    }

    public User validateLogin(String email,String password){
        //User user;

    String template="SELECT * FROM users WHERE email=? AND password=?;";
    try(PreparedStatement psmt=conn.prepareStatement(template)){
        psmt.setString(1, email);
        psmt.setString(2,password);
        ResultSet rs=psmt.executeQuery();
        if(rs.next()){
             return new User(
                rs.getInt("id"),
        rs.getString("name"),
        rs.getString("email"),
        rs.getString("password")
    );

        }

       // return user;
        

    }
    catch(SQLException se){
        System.out.println(se);
    }
        return null;

    }

    }
    

