package movieTicketsBookingSystem.model;

import javax.swing.ImageIcon;

public class Movie {
    private String title;
    private String description;
    private ImageIcon poster;

    public Movie(String title, String description, ImageIcon poster) {
        this.title = title;
        this.description = description;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ImageIcon getPoster() {
        return poster;
    }

    
}
