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

    public static void initializeCounter() {
        try {
            if (file.exists()) {
                users = mapper.readValue(file,
                        new TypeReference<List<User>>() {
                        });
                int maxId = 0;

                for (User u : users) {
                    if (u._id > maxId) {
                        maxId = u._id;
                    }
                }
                User.setCounter(maxId);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

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
        return new User(name, email, type);
    }

    public static void listUsers() {
        for (User user : users) {
            System.out.println("Id: " + user._id + " | name:" + user.name + " | email:"
                    + user.email + " | type " + user.type);
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

    public static List<User> readDataFromFile() {
        try {
            users = mapper.readValue(file,
                    new TypeReference<List<User>>() {
                    });
        } catch (IOException e) {
            e.getMessage();
        }
        return users;
    }

    public static boolean deleteUser(Scanner sc) {
        try {
            System.out.println("Enter user Id:");
            int id = Integer.parseInt(sc.nextLine());
            List<User> latestusers = Utils.readDataFromFile();
            latestusers.removeIf(user -> user._id == id);
            mapper.writeValue(file, latestusers);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updateUser(Scanner sc) {
        try {
            System.out.println("Enter user Id:");
            int id = Integer.parseInt(sc.nextLine());
            List<User> latestusers = Utils.readDataFromFile();
            boolean found = false;
            for (User user : latestusers) {
                if (user._id == id) {
                    System.out.println("New Name (leave empty to keep):");
                    String name = sc.nextLine();
                    if (!name.isEmpty()) {
                        user.name = name;
                    }

                    System.out.println("New Email (leave empty to keep):");
                    String email = sc.nextLine();
                    if (!email.isEmpty()) {
                        user.email = email;
                    }

                    System.out.println("New Type (leave empty to keep):");
                    String type = sc.nextLine();
                    if (!type.isEmpty()) {
                        user.type = type;
                    }
                    found = true;
                    break;
                }

            }
            if (!found) {
                System.out.println("User not found");
                return false;
            }

            mapper.writeValue(file, latestusers);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void statics() {
        try {
            users = mapper.readValue(file,
                    new TypeReference<List<User>>() {
                    });

            
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
