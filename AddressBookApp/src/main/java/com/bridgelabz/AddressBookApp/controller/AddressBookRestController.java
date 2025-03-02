package com.bridgelabz.AddressBookApp.controller;

/*
  Use Case : 2
  - Create a Rest Controller to demonstrate the various HTTP Methods
  - In application.properties, set properties of MySQL Driver and MySQL Credentials
  - Use ResponseEntity to return JSON Response
  - At this stage the interest is to establish the connectivity and ensure
    data is transmitted in REST Calls
*/

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
    public ResponseEntity<String> creatingUser() {
        String message = "POST: creating a new user";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatingUserDetails(@PathVariable("id") long id) {
        String message = "PUT: updating a user details of id "+ id;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletingUser() {
        String message = "DELETE: deleting a user";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}