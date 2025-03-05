package com.bridgelabz.AddressBookApp.model;

public class ContactData {

    private static long counter=1;
    private long id;
    private String name;
    private String address;


    public ContactData(){
        id=counter;
        counter++;
    }

    public ContactData(String name,String address){
        this();
        setName(name);
        setAddress(address);
    }

    public long getId(){
        return id;
    }

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

    public String getDetails(){
        return "ID = " + id + ", Name = " + name + ", Address = " + address;
    }
}