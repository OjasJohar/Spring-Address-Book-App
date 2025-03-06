package com.bridgelabz.AddressBookApp.exception;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(long id){
        super("User with ID " + id + " not found.");
    }
}