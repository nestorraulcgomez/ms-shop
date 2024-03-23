package com.nrcg.ms_shop.models;

public class Address {

    private int id;
    private String street;
    private String city;
    private String country;

    public Address(int id, String street, String city, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

}
