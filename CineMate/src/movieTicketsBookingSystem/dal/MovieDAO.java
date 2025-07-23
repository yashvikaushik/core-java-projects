package movieTicketsBookingSystem.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import javax.swing.ImageIcon;

import movieTicketsBookingSystem.model.Movie;
import movieTicketsBookingSystem.dal.DBConnection;


public class MovieDAO {
    public LinkedHashMap<String,Movie> moviesLinkedHashMap= new LinkedHashMap<String,Movie>();
    
    public LinkedHashMap<String,Movie>  getAllMovies()
    { 
        Connection conn=DBConnection.getConnection();
        Movie movie;
        
            
     String template="SELECT title, description, poster  FROM movies ;";
      try(PreparedStatement psmt=conn.prepareStatement(template)){
        ResultSet rs=psmt.executeQuery();
        
        while(rs.next())
        {
            movie = new Movie(rs.getString("title"), rs.getString("description"), new ImageIcon(rs.getString("poster")));
           moviesLinkedHashMap.put( rs.getString("title"),movie);



        }

        


      }
      catch(SQLException se){
        System.out.println(se);
      }
        

        return moviesLinkedHashMap;

    } 
    
}
