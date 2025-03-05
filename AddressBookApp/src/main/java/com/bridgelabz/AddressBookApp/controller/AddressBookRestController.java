package com.bridgelabz.AddressBookApp.controller;

/*
   Use Case : 3
   This is Rest Controller file to ensure that data is transmitted in REST calls
   Note that Controller in UC3 was creating the Model and returning the Model on the REST Calls.
   Database is not used.
   Service layer is not used
 */

import com.bridgelabz.AddressBookApp.dto.ContactDTO;
import com.bridgelabz.AddressBookApp.model.ContactData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookRestController {

    @GetMapping("")
    public ResponseEntity<String> getAllAddresses() {
        String message = "GET: getting all users address details";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable("id") long id) {
        String message = "GET: getting Address details of user by id " + id;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ContactData> creatingUser(@RequestBody ContactDTO contactDTO) {
        ContactData contactData=new ContactData();
        String name=contactDTO.getName();
        String address=contactDTO.getAddress();

        contactData.setName(name);
        contactData.setAddress(address);
//        String message = "POST: creating a new user";
        return new ResponseEntity<>(contactData, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatingUserDetails(@PathVariable long id,@RequestBody ContactDTO contactDTO) {

        String message = "PUT: updating a user details";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletingUser(@PathVariable long id) {
        String message = "DELETE: deleting a user";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}