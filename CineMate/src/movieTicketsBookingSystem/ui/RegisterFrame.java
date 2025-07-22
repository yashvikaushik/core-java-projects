package movieTicketsBookingSystem.ui;

import movieTicketsBookingSystem.model.User;
import movieTicketsBookingSystem.service.UserService;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;

    private UserService userService;

    public RegisterFrame() {
        userService = new UserService(); // Initialize service
        initComponents();
        applyDarkTheme(); // Apply dark theme after components are initialized
    }

    private void initComponents() {
        setTitle("User Registration - Cinemate");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        registerButton = new JButton("Register");
        registerButton.addActionListener(e -> handleRegister());

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(nameLabel); panel.add(nameField);
        panel.add(emailLabel); panel.add(emailField);
        panel.add(passwordLabel); panel.add(passwordField);
        panel.add(new JLabel()); panel.add(registerButton);

        add(panel);
    }

    private void applyDarkTheme() {
        Color darkBg = new Color(45, 45, 45);
        Color lightText = new Color(230, 230, 230);
        Color buttonBg = new Color(70, 70, 70);

        getContentPane().setBackground(darkBg);

        for (Component c : getContentPane().getComponents()) {
            if (c instanceof JPanel panel) {
                panel.setBackground(darkBg);
                for (Component inner : panel.getComponents()) {
                    if (inner instanceof JLabel label) {
                        label.setForeground(lightText);
                    } else if (inner instanceof JTextField field) {
                        field.setBackground(buttonBg);
                        field.setForeground(lightText);
                        field.setCaretColor(lightText);
                    } else if (inner instanceof JPasswordField passField) {
                        passField.setBackground(buttonBg);
                        passField.setForeground(lightText);
                        passField.setCaretColor(lightText);
                    } else if (inner instanceof JButton button) {
                        button.setBackground(new Color(90, 90, 90));
                        button.setForeground(lightText);
                        button.setFocusPainted(false);
                        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                    }
                }
            }
        }
    }

    private void handleRegister() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("user");

        boolean success = userService.registerUser(user);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Close window or redirect
        } else {
            JOptionPane.showMessageDialog(this, "Email already registered or error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterFrame().setVisible(true));
    }
}