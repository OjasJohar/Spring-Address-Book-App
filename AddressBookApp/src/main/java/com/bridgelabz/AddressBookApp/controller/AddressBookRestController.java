package com.bridgelabz.AddressBookApp.controller;

/*
   Use Case : 10
   Adding Validation to Name Field(ContactDTO) so the REST call can be validated
   - To begin with make it a required field i.e. a not empty field (@NotBlank)
   - Then add pattern to it. (@Pattern)
   - The Validation needs to be done for both Create and Update REST Calls. (using @Valid on @RequestBody)
*/

import com.bridgelabz.AddressBookApp.dto.ContactDTO;
import com.bridgelabz.AddressBookApp.model.ContactData;
import com.bridgelabz.AddressBookApp.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookRestController {

    @Autowired
    AddressService addressService;

    @GetMapping("")
    public ResponseEntity<List<ContactData>> getAllAddresses() {
        List<ContactData> contactDataList = addressService.getAllAddress();
        return new ResponseEntity<>(contactDataList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ContactData> getAddressById(@PathVariable("id") long id) {
        ContactData contactData = addressService.getAddressByID(id);
        return new ResponseEntity<>(contactData, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ContactData> creatingUser(@Valid @RequestBody ContactDTO contactDTO) {
        ContactData contactData=addressService.creatingUser(contactDTO);
        return new ResponseEntity<>(contactData, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContactData> updatingUserDetails(@Valid @PathVariable long id,@RequestBody ContactDTO contactDTO) {
        ContactData contactData=addressService.updatingUserData(id,contactDTO);
        return new ResponseEntity<>(contactData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletingUser(@PathVariable long id) {
        String message = addressService.deleteUser(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}