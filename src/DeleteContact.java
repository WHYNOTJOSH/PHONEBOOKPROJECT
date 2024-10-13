package PhoneBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteContact extends JFrame {
    private JTextField nameField;
    private ContactManager contactManager;

    
    public DeleteContact(ContactManager contactManager) {
        this.contactManager = contactManager;

        
        setTitle("Delete Contact");
        setLayout(null);
        setSize(400, 200);

        
        JLabel nameLabel = new JLabel("Enter Name to Delete:");
        nameLabel.setBounds(50, 30, 150, 30);
        nameField = new JTextField();
        nameField.setBounds(200, 30, 150, 30);

        
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(150, 70, 100, 30);
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 110, 100, 30);

       
        add(nameLabel);
        add(nameField);
        add(deleteButton);
        add(backButton);

        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                boolean deleted = contactManager.deleteContact(name);
                if (deleted) {
                    JOptionPane.showMessageDialog(null, "Contact deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Contact not found.");
                }
                nameField.setText(""); // Clear the input field
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
