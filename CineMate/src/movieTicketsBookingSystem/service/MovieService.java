package movieTicketsBookingSystem.service;

import java.util.LinkedHashMap;
import movieTicketsBookingSystem.dal.MovieDAO;
import movieTicketsBookingSystem.model.Movie;

public class MovieService {

    MovieDAO movieDAO = new MovieDAO();
    public LinkedHashMap<String, Movie> getAllMovies(){
        return movieDAO.getAllMovies();
    }
    
}
