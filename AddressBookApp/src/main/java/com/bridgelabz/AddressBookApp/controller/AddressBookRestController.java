package com.bridgelabz.AddressBookApp.controller;

/*
   Use Case : 4
   This is Rest Controller file to ensure that data is transmitted in REST calls.
   Note that Controller in UC4 was calling services layer to manage the Model.
   Service Layer: creating the Model and returning the Model on the REST Calls(Controller).
   Database is not used.
*/

import com.bridgelabz.AddressBookApp.dto.ContactDTO;
import com.bridgelabz.AddressBookApp.model.ContactData;
import com.bridgelabz.AddressBookApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookRestController {

    @Autowired
    AddressService addressService;

    @GetMapping("")
    public ResponseEntity<String> getAllAddresses() {
        String message = addressService.getAllAddress();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable("id") long id) {
        String message = addressService.getAddressByID(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ContactData> creatingUser(@RequestBody ContactDTO contactDTO) {
        ContactData contactData=addressService.creatingUser(contactDTO);
        return new ResponseEntity<>(contactData, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContactData> updatingUserDetails(@PathVariable long id,@RequestBody ContactDTO contactDTO) {
        ContactData contactData=addressService.updatingUserData(id,contactDTO);
        return new ResponseEntity<>(contactData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletingUser(@PathVariable long id) {
        String message = addressService.deleteUser(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}