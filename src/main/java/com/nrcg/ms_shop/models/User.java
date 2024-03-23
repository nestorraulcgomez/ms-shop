package com.nrcg.ms_shop.models;

import java.util.List;

public class User {

    private String name;
    private String lastname;
    private String email;
    private List<Address> addresses;

    public User(String name, String lastname, String email, List<Address> addresses) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

}
