package test;

import static org.junit.jupiter.api.Assertions.*;    // Imports all JUnit assertion methods
import org.junit.jupiter.api.Test;                   // Imports the @Test annotation
import contactService.Contact;                       // Imports the Contact class that is being tested

class ContactTest {

    // Tests to create a valid contact
    @Test
    void testContact() {

        // Creates a valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Confirms that contactID, first name, last name, phone, and address is stored correctly
        assertTrue(contact.getContactId().equals("12345"));
        assertTrue(contact.getFirstName().equals("John"));
        assertTrue(contact.getLastName().equals("Doe"));
        assertTrue(contact.getPhone().equals("1234567890"));
        assertTrue(contact.getAddress().equals("123 Street"));
    }

    // Tests that the constructor rejects any value that is too long
    @Test
    void testConstructorRejectTooLongValues() {

        // Contact ID too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Street");
        });

        // First name too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnJohnJohn", "Doe", "1234567890", "123 Stree");
        });

        // Last name too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "123 Street");
        });

        // Phone number too short
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789", "123 Street");
        });

        // Address too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "123 Street 123 Street 123 Street");
        });
    }

    // Tests that the constructor rejects any field that is null
    @Test
    void testConstructorRejectNullValues() {

        // Contact ID not null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Street");
        });

        // First name not null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Street");
        });

        // Last name not null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Street");
        });

        // Phone number not null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Street");
        });

        // Address not null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }

    // Tests that setting a valid first name works correctly
    @Test
    void testSetFirstNameValid() {

        // Creates a new valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Updates the first name to a valid value and confirms the first name was updated
        contact.setFirstName("Joe");
        assertEquals("Joe", contact.getFirstName());
    }

    // Tests that setting a valid last name works correctly
    @Test
    void testSetLastNameValid() {

        // Creates a new valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Updates the last name to a valid value and confirms the last name was updated
        contact.setLastName("Schmoe");
        assertEquals("Schmoe", contact.getLastName());
    }

    // Tests that setting a valid phone number works correctly
    @Test
    void testSetPhoneValid() {

        // Creates a new valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Updates the phone number to a valid value and confirms the phone number was updated
        contact.setPhone("5557779999");
        assertEquals("5557779999", contact.getPhone());
    }

    // Tests that setting a valid address works correctly
    @Test
    void testSetAddressValid() {

        // Creates a new valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Updates the address to a valid value and confirms the address was updated
        contact.setAddress("321 Avenue");
        assertEquals("321 Avenue", contact.getAddress());
    }

    // Tests that all setters accept valid values
    @Test
    void testSettersValidValues() {

        // Creates a new valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Make valid updates
        contact.setFirstName("Joe");
        contact.setLastName("Schmoe");
        contact.setPhone("5557779999");
        contact.setAddress("321 Avenue");

        // Confirm updates
        assertEquals("Joe", contact.getFirstName());
        assertEquals("Schmoe", contact.getLastName());
        assertEquals("5557779999", contact.getPhone());
        assertEquals("321 Avenue", contact.getAddress());
    }

    // Tests setters to reject values that are too long
    @Test
    void testSettersRejectTooLongValues() {

        // Creates a new valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Too long first name
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohnJohn"));

        // Too long last name
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("DoeDoeDoeDoe"));

        // Phone has too many digits
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901"));

        // Too long address
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("123 Street".repeat(4)));
    }

    // Tests setters to reject null values
    @Test
    void testSettersRejectNullValues() {

        // Creates a new valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");

        // Each setter should throw an IllegalArgumentException when given null
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
