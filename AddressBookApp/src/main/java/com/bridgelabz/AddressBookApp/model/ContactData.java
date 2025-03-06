package com.bridgelabz.AddressBookApp.model;

import lombok.Data;

@Data
public class ContactData {

    private static long counter=1;
    private long id;
    private String name;
    private String address;


    public ContactData(){
        id=counter;
        counter++;
    }

    public ContactData(long id,String name,String address){
        this.id=id;
        setName(name);
        setAddress(address);
    }
}