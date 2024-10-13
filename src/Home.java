package PhoneBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private ContactManager contactManager;

    // Constructor
    public Home(ContactManager contactManager) {
        this.contactManager = contactManager;

        // Set the title
        setTitle("Phone Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);

        // Create buttons for the main options
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton displayButton = new JButton("Display All");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton exitButton = new JButton("Exit");

        // Set bounds for each button
        addButton.setBounds(50, 50, 100, 40);
        searchButton.setBounds(50, 100, 100, 40);
        displayButton.setBounds(50, 150, 100, 40);
        editButton.setBounds(50, 200, 100, 40);
        deleteButton.setBounds(50, 250, 100, 40);
        exitButton.setBounds(50, 300, 100, 40);

        // Add buttons to the frame
        add(addButton);
        add(searchButton);
        add(displayButton);
        add(editButton);
        add(deleteButton);
        add(exitButton);

        // Add button actions
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddContact(contactManager).setVisible(true);
                dispose();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SearchContact(contactManager).setVisible(true);
                dispose();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DisplayAllContacts(contactManager).setVisible(true);
                dispose();
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EditContact(contactManager).setVisible(true);
                dispose();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteContact(contactManager).setVisible(true);
                dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Set window visibility
        setVisible(true);
    }

    // Main method to start the program with the login page
    public static void main(String[] args) {
        // Call the login page before showing the home page
        new Login();
    }

    Home() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
