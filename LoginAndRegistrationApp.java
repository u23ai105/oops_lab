package LoginAndRegistrationApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginAndRegistrationApp extends JFrame implements ActionListener {
    private JTextField usernameField, emailField;
    private JPasswordField passwordField;
    private JButton submitButton, toggleButton;
    private JLabel messageLabel;
    private boolean isRegistration = true;

    private Connection connection;

    public LoginAndRegistrationApp() {
        // Initialize database connection
        initializeDB();

        // Set up the GUI
        setTitle("Login & Registration");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Components
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        emailField = new JTextField();
        submitButton = new JButton("Register");
        toggleButton = new JButton("Switch to Login");
        messageLabel = new JLabel("", JLabel.CENTER);

        // Add components
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Email (only for registration):"));
        add(emailField);

        add(submitButton);
        add(toggleButton);
        add(messageLabel);

        // Add action listeners
        submitButton.addActionListener(this);
        toggleButton.addActionListener(this);

        toggleRegistrationMode(); // Initialize in registration mode
        setVisible(true);
    }

    private void initializeDB() {
        try {
            // Update your database credentials here
            String url = "jdbc:mysql://localhost:3306/user_db";
            String user = "root";
            String password = "your_password";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            System.exit(1);
        }
    }

    private void toggleRegistrationMode() {
        isRegistration = !isRegistration;
        emailField.setEnabled(isRegistration);
        submitButton.setText(isRegistration ? "Register" : "Login");
        toggleButton.setText(isRegistration ? "Switch to Login" : "Switch to Register");
        messageLabel.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toggleButton) {
            toggleRegistrationMode();
        } else if (e.getSource() == submitButton) {
            if (isRegistration) {
                registerUser();
            } else {
                loginUser();
            }
        }
    }

    private void registerUser() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String email = emailField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            messageLabel.setText("All fields are required!");
            return;
        }

        try {
            String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, email);

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                messageLabel.setText("Registration successful!");
                clearFields();
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            messageLabel.setText("Username or email already exists!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            messageLabel.setText("Registration failed!");
        }
    }

    private void loginUser() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("All fields are required!");
            return;
        }

        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid credentials!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            messageLabel.setText("Login failed!");
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginAndRegistrationApp::new);
    }
}