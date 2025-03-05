package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.ContactDTO;
import com.bridgelabz.AddressBookApp.model.ContactData;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    public String getAllAddress(){
        return "GET: getting all users address details";
    }

    public String getAddressByID(long id){
        return "GET: getting Address details of user by id " + id;
    }

    public ContactData creatingUser(ContactDTO contactDTO){
        ContactData contactData=new ContactData();
        String name=contactDTO.getName();
        String address=contactDTO.getAddress();

        contactData.setName(name);
        contactData.setAddress(address);

        return contactData;
    }

    public ContactData updatingUserData(long id, ContactDTO contactDTO){
        String name=contactDTO.getName();
        String address=contactDTO.getAddress();

        ContactData contactData=new ContactData(id,name,address);
        return contactData;
    }

    public String deleteUser(long id){
        return "DELETE: deleting a user with id " + id;
    }
}