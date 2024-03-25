package com.nrcg.ms_shop.models;

import java.util.List;

public class User {

    private int id;
    private String name;
    private String lastname;
    private List<Role> roles;
    private List<Address> addresses;

    public User(int id, String name, String lastname, List<Role> roles, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.roles = roles;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

}
