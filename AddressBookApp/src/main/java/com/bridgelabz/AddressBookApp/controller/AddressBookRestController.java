package com.bridgelabz.AddressBookApp.controller;

/*
   Use Case : 12
   Ability to throw User Friendly Errors in case Employee Id is not found in Employee Payroll App.
   - Define a Custom Exception for Employee Not Found and through when Employee Id is passed as parameter.
   - Handle such Exceptions in @ExceptionHandler method for EmployeeNotException class.
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