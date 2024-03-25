package com.nrcg.ms_shop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nrcg.ms_shop.models.Address;
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
        System.out.println("UserController created");
        users.add(
                new User(
                        "Nestor", "Castillo", 1,
                        Arrays.asList(
                                new Address(1, "Calle 1", "Ciudad 1", "Pais 1"),
                                new Address(2, "Calle 2", "Ciudad 2", "Pais 2"))));
        users.add(
                new User(
                        "Juan", "Urrutia", 2,
                        Arrays.asList(
                                new Address(1, "Calle 3", "Ciudad 3", "Pais 3"),
                                new Address(2, "Calle 4", "Ciudad 4", "Pais 4"),
                                new Address(3, "Calle 5", "Ciudad 5", "Pais 5"))));
        users.add(
                new User(
                        "Ivan", "Perez", 3,
                        Arrays.asList(
                                new Address(1, "Calle 6", "Ciudad 6", "Pais 6"))));
        users.add(
                new User(
                        "Pablo", "Garcia", 4,
                        Arrays.asList()));
        System.out.println("Users added");
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        if (userId < 1 || userId > users.size()) {
            throw new RuntimeException("User does not exist");
        }
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
