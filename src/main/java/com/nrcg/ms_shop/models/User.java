package com.nrcg.ms_shop.models;

import java.util.List;

public class User {

    private String name;
    private String lastname;
    private int id;
    private List<Address> addresses;

    public User(String name, String lastname, int id, List<Address> addresses) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

}
