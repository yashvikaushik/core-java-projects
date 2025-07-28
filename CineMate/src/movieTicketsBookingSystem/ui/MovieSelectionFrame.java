package movieTicketsBookingSystem.ui;

import javax.swing.*;

import movieTicketsBookingSystem.model.Movie;
import movieTicketsBookingSystem.model.User;
import movieTicketsBookingSystem.service.MovieService;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class MovieSelectionFrame extends JFrame {

    private final int MAX_SEATS = 10; // Max seats to select
    private User user;

    private MovieService movieService = new MovieService();
    private Map<String, Movie> movies = new LinkedHashMap<String, Movie>();

    public MovieSelectionFrame(User user) {
        this.user = user;
        setTitle("Select a Movie");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        movies = movieService.getAllMovies();

        JPanel gridPanel = new JPanel(new GridLayout(0, 2, 20, 20)); // 2 columns, expandable rows
        gridPanel.setBackground(Color.DARK_GRAY);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (Movie movie : movies.values()) {
            gridPanel.add(createMovieCard(movie));
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            this.dispose(); // Go back to login/home frame
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(backBtn);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createMovieCard(Movie movie) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(400, 220));
        card.setBackground(Color.GRAY);
        card.setLayout(new BorderLayout(10, 10));
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Poster
        ImageIcon posterIcon = movie.getPoster();
        Image scaledImage = posterIcon.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH);
        JLabel posterLabel = new JLabel(new ImageIcon(scaledImage));
        card.add(posterLabel, BorderLayout.WEST);

        // Center Panel for Title & Description
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.GRAY);

        JLabel titleLabel = new JLabel(movie.getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        centerPanel.add(titleLabel, BorderLayout.NORTH);

        JTextArea descArea = new JTextArea(movie.getDescription());
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.setEditable(false);
        descArea.setOpaque(false);
        descArea.setForeground(Color.WHITE);
        centerPanel.add(descArea, BorderLayout.CENTER);

        card.add(centerPanel, BorderLayout.CENTER);

        // Select button
        JButton selectBtn = new JButton("Select");
        selectBtn.addActionListener(e -> {
            new SeatSelectionFrame(user.getID(), movie.getID()).setVisible(true);
            this.setVisible(false);
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.GRAY);
        btnPanel.add(selectBtn);

        card.add(btnPanel, BorderLayout.SOUTH);

        return card;
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> new MovieSelectionFrame().setVisible(true));
    // }
}