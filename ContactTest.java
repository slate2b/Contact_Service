package contactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	// Testing the Contact class constructor with valid attribute values
	@Test
	void testContactClass() {
		
		Contact contact = new Contact("1234567890", "SallyMarie", "Longnameio", "5555555555", "12345 LongExample St, Apt 1234");
		assertTrue(contact.getContactId().equals("1234567890"));
		assertTrue(contact.getFirstName().equals("SallyMarie"));
		assertTrue(contact.getLastName().equals("Longnameio"));
		assertTrue(contact.getNumber().equals("5555555555"));
		assertTrue(contact.getAddress().equals("12345 LongExample St, Apt 1234"));
	}
	
	// Testing the invalid id exception with contactId too long
	@Test
	void testIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "SallyMarie", "Longnameio", "5555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid id exception with a null value
	@Test
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "SallyMarie", "Longnameio", "5555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid first name exception with firstName too long
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarieE", "Longnameio", "5555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid first name exception with a null value
	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "Longnameio", "5555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid last name exception with lastName too long
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarie", "LongnameioO", "5555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid last name exception with a null value
	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarie", null, "5555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid number exception with number less than 10 chars
	@Test
	void testNumberTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarie", "Longnameio", "555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid number exception with number more than 10 chars
	@Test
	void testNumberTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarie", "Longnameio", "55555555555", "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid number exception with a null value
	@Test
	void testNumberNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarie", "Longnameio", null, "12345 LongExample St, Apt 1234");
		}); 
	}
	
	// Testing the invalid address exception with address too long
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarie", "Longnameio", "5555555555", "12345 LongExample St, Apt 12345");
		}); 
	}
	
	// Testing the invalid address exception with a null value
	@Test
	void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "SallyMarie", "Longnameio", "5555555555", null);
		}); 
	}
	
}
