package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.ContactDTO;
import com.bridgelabz.AddressBookApp.model.ContactData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    List<ContactData> contactDatalist;

    public AddressService(){
        contactDatalist=new ArrayList<>();
    }

    public List<ContactData> getAllAddress(){
        return contactDatalist;
    }

    public ContactData getAddressByID(long id){
        for(ContactData contactData:contactDatalist){
            if(contactData.getId()==id){
                return contactData;
            }
        }
        return null;
    }

    public ContactData creatingUser(ContactDTO contactDTO){
        ContactData contactData=new ContactData();
        String name=contactDTO.getName();
        String address=contactDTO.getAddress();

        contactData.setName(name);
        contactData.setAddress(address);
        contactDatalist.add(contactData);
        return contactData;
    }

    public ContactData updatingUserData(long id, ContactDTO contactDTO) {
        String name = contactDTO.getName();
        String address = contactDTO.getAddress();

        ContactData contactData = getAddressByID(id);
        if (name != null) {
            contactData.setName(name);
        }
        if (address != null) {
            contactData.setAddress(address);
        }

        int temp = -1;
        for (int i = 0; i < contactDatalist.size(); i++) {
            if (contactDatalist.get(i).getId() == id) {
                temp = i;
                break;
            }
        }
        contactDatalist.remove(temp);
        contactDatalist.add(contactData);

        return contactData;
    }

    public String deleteUser(long id){
        int temp = -1;
        for (int i = 0; i < contactDatalist.size(); i++) {
            if (contactDatalist.get(i).getId() == id) {
                temp = i;
                break;
            }
        }
        contactDatalist.remove(temp);
        return "DELETE: deleting a user with id " + id;
    }
}