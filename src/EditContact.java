package PhoneBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditContact extends JFrame {
    private JTextField nameField, phoneField, emailField;
    private ContactManager contactManager;

    // Constructor
    public EditContact(ContactManager contactManager) {
        this.contactManager = contactManager;

        // Set the title and layout
        setTitle("Edit Contact");
        setLayout(null);
        setSize(400, 300);

        // Create and configure labels and fields
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(50, 30, 150, 30);
        nameField = new JTextField();
        nameField.setBounds(200, 30, 150, 30);

        JLabel phoneLabel = new JLabel("New Phone:");
        phoneLabel.setBounds(50, 70, 150, 30);
        phoneField = new JTextField();
        phoneField.setBounds(200, 70, 150, 30);

        JLabel emailLabel = new JLabel("New Email:");
        emailLabel.setBounds(50, 110, 150, 30);
        emailField = new JTextField();
        emailField.setBounds(200, 110, 150, 30);

        // Create buttons
        JButton editButton = new JButton("Edit");
        editButton.setBounds(150, 150, 100, 30);
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 190, 100, 30);

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(phoneLabel);
        add(phoneField);
        add(emailLabel);
        add(emailField);
        add(editButton);
        add(backButton);

        // Action listener for the Edit button
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String newPhone = phoneField.getText();
                String newEmail = emailField.getText();

                // Call the edit method on the contact manager
                boolean updated = contactManager.editContact(name, newPhone, newEmail);
                if (updated) {
                    JOptionPane.showMessageDialog(null, "Contact updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Contact not found.");
                }
                clearFields(); // Clear input fields after editing
            }
        });

        // Action listener for the Back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home(contactManager).setVisible(true);
                dispose();
            }
        });

        // Set visibility
        setVisible(true);
    }

    // Method to clear input fields
    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }
}
