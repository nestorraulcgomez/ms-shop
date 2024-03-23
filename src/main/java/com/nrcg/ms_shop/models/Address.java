package com.nrcg.ms_shop.models;

public class Address {

    private String street;
    private String city;
    private String country;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
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
