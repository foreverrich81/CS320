package contactService;

import java.util.HashMap;	// Allows use of Hash Map
import java.util.Map;		// Allows use of Map

public class ContactService {
	
	// This Map is where all contacts are stored, organized by their ID in a HashMap
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// Adds a new contact and returns false if contact with same ID already exists
	public boolean addContact(Contact contact) {
		
		// Check if the ID is already in use
		if (contacts.containsKey(contact.getContactId())) {
			return false;
		}
		
		// Store the contact in the Map using the ID as the key
		contacts.put(contact.getContactId(), contact);
			return true;
	}
	
	// Deletes a contact by its ID
	public boolean deleteContact(String contactId) {
		
		
		return contacts.remove(contactId) != null;
	}
	
	// Update the first name of the contact with the given ID
	public boolean updateFirstName(String contactId, String firstName) {
		
		// Look up the contact by ID
		Contact contact = contacts.get(contactId);
		
		// If no contact exist, update contact cannot happen
		if (contact == null) {
			return false;
		}
		
		// Use the contact's class setter
		contact.setFirstName(firstName);
		return true;
	}
	
	// Update the last name of the contact with the given ID
	public boolean updateLastName(String contactId, String lastName) {
		
		// Look up the contact by ID
		Contact contact = contacts.get(contactId);
		
		// If no contact exist, update contact cannot happen
		if (contact == null) {
			return false;
		}
		
		// Use the contact's class setter
		contact.setLastName(lastName);
		return true;
	}
	
	// Update the phone number of the contact with the given ID
	public boolean updatePhone(String contactId, String phone) {
		
		// Look up the contact by ID
		Contact contact = contacts.get(contactId);
		
		// If no contact exist, update contact cannot happen
		if (contact == null) {
			return false;
		}
		
		// Use the contact's class setter
		contact.setPhone(phone);
		return true;
	}
	
	// Update the address of the contact with the given ID
	public boolean updateAddress(String contactId, String address) {
		
		// Look up the contact by ID
		Contact contact = contacts.get(contactId);
		
		// If no contact exist, update contact cannot happen
		if (contact == null) {
			return false;
		}
		
		// Use the contact's class setter
		contact.setAddress(address);
		return true;
	}
	
	// Returns a contact object by its ID
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}
