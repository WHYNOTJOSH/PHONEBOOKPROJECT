package PhoneBook;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class DisplayAllContacts extends JFrame {
    private ContactManager contactManager;
    private JTextArea textArea;

    public DisplayAllContacts(ContactManager contactManager) {
        this.contactManager = contactManager;

        
        setTitle("All Contacts");
        setSize(400, 300);
        setLayout(new BorderLayout());

       
        textArea = new JTextArea();
        textArea.setEditable(false);
        
       
        displayContacts();

        
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.setVisible(false);
            new Home(contactManager).setVisible(true); // Go back to Home
        });
        add(backButton, BorderLayout.SOUTH);

        
        setVisible(true);
    }

    private void displayContacts() {
        LinkedList<Contact> contacts = contactManager.getAllContacts(); // Assuming this method exists
        if (contacts.isEmpty()) {
            textArea.setText("No contacts found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Contact contact : contacts) {
                sb.append("Name: ").append(contact.getName()).append("\n");
                sb.append("Phone: ").append(contact.getPhone()).append("\n");
                sb.append("Email: ").append(contact.getEmail()).append("\n\n");
            }
            textArea.setText(sb.toString());
        }
    }
}
