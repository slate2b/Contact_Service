
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

import java.util.ArrayList;

public class ContactService {
	
	public static int searchContact(String contact_id, ArrayList<Contact> list) {
		
		// int variable for the index of matching object
		int searchIndex = -1;
		
		// Loop through list and search based on id
		for (int i = 0; i < list.size(); i++) {
			if (contact_id == list.get(i).getContactId()) {
				searchIndex = i;
			}
		}
		
		return searchIndex;
	}
	
	public static void addContact(String contact_id, String first_name, String last_name, String number, String address, ArrayList<Contact> list) {
		
		// Search list based on id
		int lookupIndex = searchContact(contact_id, list); // search returns -1 if id is not found
		
		// If id is unique
		if (lookupIndex == -1) {
			
			// Create new object
			Contact contact = new Contact(contact_id, first_name, last_name, number, address);	
			
			// Add the new object to the list
			list.add(contact);
		}
		
		// If contactId is NOT unique
		else {
			throw new IllegalArgumentException("Duplicate ID");
		}
	}
	
	public static void deleteContact(String contact_id, ArrayList<Contact> list) {
		
		// Search list based on id
		// The search method returns -1 if not found, otherwise returns the index of the object in the list
		int lookupIndex = searchContact(contact_id, list); 
		
		// If id is found
		if (lookupIndex != -1) {
			
			// Delete object
			list.remove(lookupIndex);
		}
		
		else {
			throw new IllegalArgumentException("Contact not found");
		}
	}
	
	public static void updateContact(String contact_id, String first_name, String last_name, String number, String address, ArrayList<Contact> list) {
		
		// A Contact variable to temporarily hold contact data
		Contact tempContact;
		
		// Search list based on id
		// The search method returns -1 if not found, otherwise returns the index of the object in the list
		int lookupIndex = searchContact(contact_id, list); 
		
		// If id is found
		if (lookupIndex != -1) {
			
			// Assign the object we found to the temp variable
			tempContact = list.get(lookupIndex);
			
			// update temp variable based on the arguments passed through the updateContact method call
			// Note: the id stays the same
			tempContact.setFirstName(first_name);
			tempContact.setLastName(last_name);
			tempContact.setNumber(number);
			tempContact.setAddress(address);

			// update the corresponding object in list
			list.set(lookupIndex, tempContact);
		}
		
		else {
			throw new IllegalArgumentException("Contact not found");
		}
		
	}
}
