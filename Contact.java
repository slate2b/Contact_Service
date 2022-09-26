
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
// 
//  This Contact Service project is part of a small collection of back-end services developed for a hypothetical 
//  Mobile App.  The Contact Service is designed to allow a user to manage their customer contacts.  
//  It includes a Contact class for Contact objects and a ContactService class which provides the necessary 
//  back-end functionality for the service.  The Contact class contains basic getters and setters along with 
//  exception-handling to meet specifications.  The ContactService class contains methods which  provide functionality
//  to add a contact, delete a contact, and update a contact.  
//
//  This project also includes JUnit tests designed to maximize test coverage and value.  JUnit tests in the ContactTest
//  class and ContactServiceTest class are implemented with input values which clearly demonstrate whether or not each 
//  component meets the specification with as much code coverage as possible.  
//  Coverage percentages for this service are 100% for the Contact class and 97.1% for the ContactService class. 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package contactService;

public class Contact {

	// Class Variables
	private String contactId = ""; // <= 10 chars, can't be null, not updatable
	private String firstName = ""; // <= 10 chars, can't be null
	private String lastName = ""; // <= 10 chars, can't be null
	private String Number = ""; // must == 10 chars, can't be null
	private String Address = ""; // <= 30 chars, can't be null
	
	// Full Constructor
	public Contact(String contact_id, String first_name, String last_name, String number, String address) {
		setContactId(contact_id);
		setFirstName(first_name);
		setLastName(last_name);
		setNumber(number);
		setAddress(address);
	}

	/*********************
	 * Getters and Setters
	 *********************/
	
	public String getContactId() {
		return contactId;
	}

	// Requirements: unique, <= 10 chars, can't be null, not updatable 
	// Handling unique and not updateable requirements in addContact method)
	public void setContactId(String contact_id) {
		if (contact_id == null || contact_id.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.contactId = contact_id;
	}

	public String getFirstName() {
		return firstName;
	}

	// Requirements: <= 10 chars, can't be null
	public void setFirstName(String first_name) {
		if (first_name == null || first_name.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	// Requirements: <= 10 chars, can't be null
	public void setLastName(String last_name) {
		if (last_name == null || last_name.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = last_name;
	}

	public String getNumber() {
		return Number;
	}

	// Requirements: must == 10 chars, can't be null
	public void setNumber(String number) {
		if (number == null || number.length()!=10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		this.Number = number;
	}

	public String getAddress() {
		return Address;
	}

	// Requirements: <= 30 chars, can't be null
	public void setAddress(String address) {
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.Address = address;
	}
}
