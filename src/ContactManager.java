package PhoneBook;

import java.util.LinkedList;

public class ContactManager {
    private LinkedList<Contact> contacts;

    public ContactManager() {
        contacts = new LinkedList<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Search for a contact by name
    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null; // Not found
    }

    // Edit an existing contact
    public boolean editContact(String name, String newPhone, String newEmail) {
        Contact contact = searchContact(name);
        if (contact != null) {
            contact.setPhone(newPhone);
            contact.setEmail(newEmail);
            return true; // Edit successful
        }
        return false; // Contact not found
    }

    // Delete a contact
    public boolean deleteContact(String name) {
        Contact contact = searchContact(name);
        if (contact != null) {
            contacts.remove(contact);
            return true; // Deletion successful
        }
        return false; // Contact not found
    }

    // Retrieve all contacts
    public LinkedList<Contact> getAllContacts() {
        return contacts;
    }
}
