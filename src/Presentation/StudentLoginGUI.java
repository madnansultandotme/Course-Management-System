import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLoginGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField emailField;
    private JPasswordField passwordField;

    public StudentLoginGUI() {
        frame = new JFrame("Student Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel emailLabel = new JLabel("Email:");
        panel.add(emailLabel);

        emailField = new JTextField();
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        panel.add(loginButton);

        JButton forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showForgotPasswordDialog();
            }
        });
        panel.add(forgotPasswordButton);
    }

    private void loginUser() {
        String email = emailField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // Perform login validation logic
        boolean isValidLogin = validateLogin(email, password);

        if (isValidLogin) {
            JOptionPane.showMessageDialog(frame, "Login successful! Welcome to the course management system.");
            // Add logic to open the main application window or perform other actions upon successful login.
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid login details. Please try again or reset your password.");
        }
    }

    private void showForgotPasswordDialog() {
        String userEmail = JOptionPane.showInputDialog(frame, "Enter your email address:");
        // Add logic to handle the forgot password process with the provided email address.
        JOptionPane.showMessageDialog(frame, "Password reset instructions sent to your email.");
    }

    private boolean validateLogin(String email, String password) {
        // Implement validation logic, e.g., check against the user database.
        // In a real application, this should involve server-side validation.
        return !email.isEmpty() && !password.isEmpty();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentLoginGUI();
            }
        });
    }
}