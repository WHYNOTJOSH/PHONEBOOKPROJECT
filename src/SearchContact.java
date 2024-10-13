package PhoneBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchContact extends JFrame {
    private JTextField nameField;
    private JTextArea resultArea;
    private ContactManager contactManager;

    
    public SearchContact(ContactManager contactManager) {
        this.contactManager = contactManager;

        
        setTitle("Search Contact");
        setLayout(null);
        setSize(400, 300);

        
        JLabel nameLabel = new JLabel("Enter Name to Search:");
        nameLabel.setBounds(50, 30, 150, 30);
        nameField = new JTextField();
        nameField.setBounds(200, 30, 150, 30);

        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(150, 70, 100, 30);
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 110, 100, 30);

        
        resultArea = new JTextArea();
        resultArea.setBounds(50, 150, 300, 100);
        resultArea.setEditable(false);

        
        add(nameLabel);
        add(nameField);
        add(searchButton);
        add(backButton);
        add(resultArea);

        
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Contact contact = contactManager.searchContact(name);
                if (contact != null) {
                    resultArea.setText(contact.toString());
                } else {
                    resultArea.setText("Contact not found.");
                }
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
