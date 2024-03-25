package com.nrcg.ms_shop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nrcg.ms_shop.models.Address;
import com.nrcg.ms_shop.models.Role;
import com.nrcg.ms_shop.models.User;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {
        System.out.println("UserController");
        users.add(
                new User(
                        1, "John", "Doe",
                        Arrays.asList(new Role(2, "ADMIN")),
                        Arrays.asList(new Address(1, "Arturo Prat", "Santiago", "Chile"),
                                new Address(2, "Providencia", "Santiago", "Chile"))));
        users.add(
                new User(
                        2, "Jane", "Doe",
                        Arrays.asList(new Role(1, "USER")),
                        Arrays.asList(new Address(1, "Teatinos", "Santiago", "Chile"),
                                new Address(2, "Alonso de Ovalle", "Santiago", "Chile"))));
        users.add(
                new User(
                        3, "Peter", "Parker",
                        Arrays.asList(new Role(1, "USER")),
                        Arrays.asList(new Address(1, "Av. Independencia", "Santiago", "Chile"))));
        System.out.println("Users added");
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return users.get(userId - 1);
    }

    @GetMapping("/users/{userId}/addresses")
    public List<Address> getAddressesByUserId(@PathVariable("userId") int userId) {
        return users.get(userId - 1).getAddresses();
    }

    @GetMapping("/users/{userId}/addresses/{addressId}")
    public Map<String, String> getFullAddress(
            @PathVariable("userId") int userId,
            @PathVariable("addressId") int addressId) {
        Address address = users.get(userId - 1).getAddresses().get(addressId - 1);
        String fullAdress = String.format("%s, %s, %s", address.getStreet(), address.getCity(), address.getCountry());
        Map<String, String> response = new HashMap<>();
        response.put("fullAdress", fullAdress);
        return response;
    }

}
