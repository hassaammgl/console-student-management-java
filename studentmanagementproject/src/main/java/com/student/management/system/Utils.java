package com.student.management.system;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    static List<User> users = new ArrayList<>();
    static File file = new File("user.json");
    static ObjectMapper mapper = new ObjectMapper();

    public static User getUser(Scanner sc) {
        String name;
        String email;
        String type;
        System.out.println("Enter username: ");
        name = sc.nextLine();
        System.out.println("Enter email: ");
        email = sc.nextLine();
        System.out.println("Enter usertype: ");
        type = sc.nextLine();
        User u = new User(name, email, type);
        return u;
    }

    public static void listUsers() {
        for (User user : users) {
            System.out.println("Id: " + user._id + " user with name:" + user.name + " also with this email:"
                    + user.email + " is " + user.type);
        }
    }

    public static boolean writeDataToFile(User u) {
        try {

            if (file.exists()) {
                users = mapper.readValue(file,
                        new TypeReference<List<User>>() {
                        });
                users.add(u);
                mapper.writeValue(file, users);
            } else {
                mapper.writeValue(file, users);
            }

            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<User> readDataFromFile() {
        try {
            users = mapper.readValue(file,
                    new TypeReference<List<User>>() {
                    });
        } catch (IOException e) {
            e.getMessage();
        }
        return users;
    }

}
