// Corrected filename: StudentSignUpGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class StudentSignUpGUI extends JFrame {

    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private Map<String, String> users;

    public StudentSignUpGUI() {
        setTitle("Course Management System - Student Sign Up");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initializeUI();
            }
        });
    }

    private void initializeUI() {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel()); // Empty label for layout spacing

        JButton signUpButton = new JButton("Sign Up");
        add(signUpButton);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });

        statusLabel = new JLabel();
        add(statusLabel);

        users = new HashMap<>(); // In-memory user storage

        setVisible(true);
    }

    private void signUp() {
        String name = nameField.getText();
        String email = emailField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
        } else if (!isValidEmail(email)) {
            statusLabel.setText("Invalid email address format.");
        } else if (users.containsKey(email)) {
            statusLabel.setText("Email address is already in use. Please choose a different one.");
        } else {
            users.put(email, password);

            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");

            statusLabel.setText("Student successfully registered!");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public static void main(String[] args) {
        new StudentSignUpGUI();
    }
}
