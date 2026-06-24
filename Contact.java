package contactService;

public class Contact {
	
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor to initialize all fields
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		
		// Validate the contact ID
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		// Validate the first name
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		// Validate the last name
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		// Validate phone number
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		// Validate address
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		// Save the validated data into the object's field
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getter for contact ID
	public String getContactId() {
		return contactId;
	}
	
	// Getter for first name
	public String getFirstName() {
		return firstName;
	}
	
	// Setter for first name with validation
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	// Getter for last name
	public String getLastName() {
		return lastName;
	}
	
	// Setter for last name with validation
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	// Getter for phone number
	public String getPhone() {
		return phone;
	}
	
	// Setter for phone number with validation
	public void setPhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Setter for address with validation
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
}
