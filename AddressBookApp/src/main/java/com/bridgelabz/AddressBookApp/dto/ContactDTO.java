package com.bridgelabz.AddressBookApp.dto;

public class ContactDTO {
    private String name;
    private String address;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress(){
        return address;
    }
}