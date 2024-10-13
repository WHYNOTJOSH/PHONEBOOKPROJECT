package PhoneBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContact extends JFrame {
    private JTextField nameField, phoneField, emailField;
    private ContactManager contactManager;

    
    public AddContact(ContactManager contactManager) {
        this.contactManager = contactManager;

        
        setTitle("Add Contact");
        setLayout(null);
        setSize(400, 400);

        
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameLabel.setBounds(50, 50, 100, 30);
        nameField.setBounds(150, 50, 150, 30);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        phoneLabel.setBounds(50, 100, 100, 30);
        phoneField.setBounds(150, 100, 150, 30);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailLabel.setBounds(50, 150, 100, 30);
        emailField.setBounds(150, 150, 150, 30);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(100, 250, 100, 30);
        JButton backButton = new JButton("Back");
        backButton.setBounds(220, 250, 100, 30);

        
        add(nameLabel);
        add(nameField);
        add(phoneLabel);
        add(phoneField);
        add(emailLabel);
        add(emailField);
        add(saveButton);
        add(backButton);

        
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();

               
                contactManager.addContact(new Contact(name, phone, email));
                JOptionPane.showMessageDialog(null, "Contact added successfully!");

               
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            }
        });

        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home(contactManager).setVisible(true);
                dispose();
            }
        });

        
        setVisible(true);
    }
}
