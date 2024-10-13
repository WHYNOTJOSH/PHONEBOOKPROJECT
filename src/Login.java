package PhoneBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JLabel userLabel, passwordLabel;

    public Login() {
        setTitle("Login Page");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Username Label and TextField
        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 80, 25);
        add(userLabel);

        userText = new JTextField();
        userText.setBounds(140, 30, 150, 25);
        add(userText);

        // Password Label and PasswordField
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 80, 25);
        add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(140, 70, 150, 25);
        add(passwordText);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(140, 110, 150, 25);
        add(loginButton);

        // Action Listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Simple check (you can replace this with database authentication)
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");

                    // Open Home Page and close the Login form
                    ContactManager contactManager = new ContactManager();  // Initialize the ContactManager
                    new Home(contactManager).setVisible(true);
                    dispose();  // Close login window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials!");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
