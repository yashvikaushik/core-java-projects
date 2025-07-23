package movieTicketsBookingSystem.ui;

import javax.swing.*;

import movieTicketsBookingSystem.model.User;
import movieTicketsBookingSystem.service.UserService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Cinemate - Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#1e1e1e")); // dark mode

        JLabel titleLabel = new JLabel("CINEMATE LOGIN");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(110, 20, 200, 30);
        add(titleLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.LIGHT_GRAY);
        emailLabel.setBounds(50, 70, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 70, 180, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.LIGHT_GRAY);
        passwordLabel.setBounds(50, 110, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 180, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 160, 90, 30);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.BLACK);
        add(loginButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(150, 160, 90, 30);
        clearButton.setBackground(new Color(105, 105, 105));
        clearButton.setForeground(Color.BLACK);
        add(clearButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(250, 160, 90, 30);
        registerButton.setBackground(new Color(34, 139, 34));
        registerButton.setForeground(Color.BLACK);
        add(registerButton);

        // Login action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User user = UserService.loginUser(email, password);
                if (user != null) {
                   // JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + user.getUserName());

                     new MovieSelectionFrame().setVisible(true);
            dispose(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Clear action
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emailField.setText("");
                passwordField.setText("");
            }
        });

        // Register action
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame().setVisible(true);
                dispose();
            }
        });

    
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}