package contactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {

	// Declare ArrayList for use in the following tests. Can be replaced with different data structure if needed in future versions.
	static private ArrayList<Contact> contactList;
	
	@BeforeAll
	static void setupAll() {
		
		// Instantiate the data structure
		contactList = new ArrayList<Contact>();
	}
	
	@BeforeEach
	void setupEach() {
		
		// Clear the list
		contactList.clear();
		
		// Add an object for testing purposes
		ContactService.addContact("1234567890", "SallyMarie", "Longnameio", "5555555555", "12345 LongExample St, Apt 1234", contactList);
	}

	// Testing the addContact method with a unique contactId
	@Test
	void testAddContact() {
		
		// Calling addContact method
		ContactService.addContact("0987654321", "SallyMarie", "Longnameio", "5555555555", "12345 LongExample St, Apt 1234", contactList);
		
		// Using index 1 since @BeforeEach created a contact at index 0
		assertTrue(contactList.get(1).getContactId().equals("0987654321"));
		assertTrue(contactList.get(1).getFirstName().equals("SallyMarie"));
		assertTrue(contactList.get(1).getLastName().equals("Longnameio"));
		assertTrue(contactList.get(1).getNumber().equals("5555555555"));
		assertTrue(contactList.get(1).getAddress().equals("12345 LongExample St, Apt 1234"));
	}
	
	// Testing the duplicate id exception by calling addContact with same contactId as existing contact
	@Test
	void testAddContactDuplicate() {
		assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact("1234567890", "SallyMarie", "Longnameio", "5555555555", "12345 LongExample St, Apt 1234", contactList);
		}); 
	}
	
	// Testing the deleteContact method with the contactId of the existing contact in contactList
	@Test
	void testDeleteContact() {
		
		// Calling deleteContact method
		ContactService.deleteContact("1234567890", contactList);
		
		// Checking to see if list is now empty
		assertTrue(contactList.isEmpty());
	}
	
	// Testing the contact not found exception by calling deleteContact with contactId which doesn't match existing contact
	@Test
	void testDeleteContactNotFound() {
		assertThrows(IllegalArgumentException.class, () -> {
			ContactService.deleteContact("4563215897", contactList);
		}); 
	}
	
	// Testing the updateContact method with valid attribute values
	// NOTE: When updating a contact, the contactId is not updatable.
	@Test
	void testUpdateContact() {
		
		//Calling updateContact method
		ContactService.updateContact("1234567890", "Sally", "Namechange", "9999999999", "12345 Different St", contactList);
		
		assertTrue(contactList.get(0).getContactId().equals("1234567890"));
		assertTrue(contactList.get(0).getFirstName().equals("Sally"));
		assertTrue(contactList.get(0).getLastName().equals("Namechange"));
		assertTrue(contactList.get(0).getNumber().equals("9999999999"));
		assertTrue(contactList.get(0).getAddress().equals("12345 Different St"));
	}
	
	// Testing the updateContact method with a contactId that doesn't match any existing records
	@Test
	void testUpdateContactNotFound() {
		assertThrows(IllegalArgumentException.class, () -> {
			ContactService.updateContact("51326987", "Sally", "Namechange", "9999999999", "12345 Different St", contactList);
		});
	}	
}
