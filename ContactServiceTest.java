package test;

import static org.junit.jupiter.api.Assertions.*;    // Imports all JUnit assertion methods
import org.junit.jupiter.api.BeforeEach;             // Imports the @BeforeEach annotation
import org.junit.jupiter.api.Test;                   // Imports the @Test annotation
import contactService.Contact;                       // Imports the Contact class
import contactService.ContactService;                // Imports the ContactService class that is being tested

class ContactServiceTest {
    
    ContactService service;   // ContactService object used for each test

    // Creates a new ContactService before each test runs
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    // Tests adding a valid contact
    @Test
    void testAddContact() {
        
        // Creates a valid Contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        
        // Confirms the contact was successfully added
        assertTrue(service.addContact(contact));
        
        // Confirms the contact is stored and retrievable
        assertTrue(service.getContact("12345").getFirstName().equals("John"));    
    }
    
    // Tests that adding a duplicate ID fails
    @Test
    void testAddDuplicateContact () {
        
        // Creates first contact 
        Contact c1 = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        
        // Creates second contact with same ID
        Contact c2 = new Contact("12345", "Richard", "Smith", "0987654321", "321 Street");
        
        // Add the first contact
        service.addContact(c1);
        
        // Add the second contact which should return false
        assertFalse(service.addContact(c2));
    }
    
    // Tests deleting a contact
    @Test
    void testDeleteContact() {
        
        // Create a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        
        // Add the contact
        service.addContact(contact);
        
        // Deleting should return true
        assertTrue(service.deleteContact("12345"));
        
        // Contact should no longer exist
        assertTrue(service.getContact("12345") == null);
    }
    
    // Tests updating the first name
    @Test
    void testUpdateFirstName() {
        
        // Creates a valid Contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        
        // Add the contact
        service.addContact(contact);
        
        // Update should succeed
        assertTrue(service.updateFirstName("12345", "Richard"));
        
        // Confirm the update worked
        assertTrue(service.getContact("12345").getFirstName().equals("Richard"));
    }
    
    // Tests updating last name
    @Test
    void testUpdateLastName() {
                
        // Creates a valid Contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
                
        // Add the contact
        service.addContact(contact);
                
        // Update should succeed
        assertTrue(service.updateLastName("12345", "Smith"));
                
        // Confirm the update worked
        assertTrue(service.getContact("12345").getLastName().equals("Smith"));
    }
    
    // Tests updating phone number
    @Test
    void testUpdatePhone() {

        // Creates a valid Contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Add the contact
        service.addContact(contact);

        // Update should succeed
        assertTrue(service.updatePhone("12345", "5597814321"));

        // Confirm the update worked
        assertTrue(service.getContact("12345").getPhone().equals("5597814321"));
    }
    
    // Tests updating the address
    @Test
    void testUpdateAddress() {

        // Creates a valid Contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Add the contact
        service.addContact(contact);

        // Update should succeed
        assertTrue(service.updateAddress("12345", "4661 State St"));

        // Confirm the update worked
        assertTrue(service.getContact("12345").getAddress().equals("4661 State St"));
    }
    
    // Tests updating a contact that does not exist
    @Test
    void testNonexistingContact() {
        
        // Should fail due to non existing ID
        assertFalse(service.updateFirstName("11111", "Bill"));
        assertFalse(service.updateLastName("11111", "Clover"));
        assertFalse(service.updatePhone("11111", "6617894567"));
        assertFalse(service.updateAddress("11111", "0921 Nancy St"));
    }
}