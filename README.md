# Contact_Service
by slate2b
---
This Contact Service project is part of a small collection of back-end services developed for a hypothetical Mobile App, utilizing JUnit tests and coverage analysis tools to reinforce quality assurance for the service.  The Contact Service is designed to allow a user to manage their customer contacts.  It includes a Contact class for Contact objects and a Contact Service class which provides the necessary back-end functionality for the service.  The Contact class contains basic getters and setters along with exception-handling to meet specifications.  The Contact Service class contains methods which  provide functionality to add a contact, delete a contact, and update a contact.  

The JUnit tests for the project are designed to maximize test coverage and value.  JUnit tests in the ContactTest class and ContactServiceTest class are implemented with input values which clearly demonstrate whether or not each component meets the specification with as much code coverage as possible.  Coverage percentages for this service are 100% for the Contact class and 97.1% for the ContactService class. 

![image](https://user-images.githubusercontent.com/88697660/192366420-f8c5c8c1-8dfe-4ce7-8b75-21afa551f42c.png)

The Contact class is designed to meet the following requirements:

* contactId's must be unique
* contactId's must be <= 10 characters
* contactId's cannot be null
* contactId's cannot be modified
* firstName must be <= 10 characters
* firstName cannot be null
* lastName must be <= 10 characters
* lastName cannot be null
* number must be == 10 characters
* number cannot be null
* address must be <= 30 characters
* address cannot be null

The ContactService class is designed to meet the following requirements:

* Allow user to add a contact
* Allow user to delete a contact
* Allow user to update a contact

The Contact Service is designed to throw exceptions for the following:

* Attempting to add a duplicate contact
* Attempting to add a contact with data which does not meet all Contact class requirements
* Attempting to update a contact which doesn't exist
* Attempting to update a contact with data which does not meet all Contact class requirements
* Attempting to delete a contact which doesn't exist

The updateContact method is designed to update all attributes except for the contactId, thereby fulfilling the business reqirement that a contactId can not be modified.

NOTE: This service is implemented using a simple ArrayList data structure and a linear search for testing purposes, but the services could easily be adapted to implementations utilizing more complex data structures and more efficienct search algorithms.
