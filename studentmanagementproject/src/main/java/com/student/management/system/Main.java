package com.student.management.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ObjectMapper mapper = new ObjectMapper();
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        new Menu(sc);

        // try {

        // mapper.writeValue(new File("user.json"), users);
        // System.out.println("JSON written successfully");
        // List<User> readedUsers = mapper.readValue(
        // new File("user.json"),
        // new TypeReference<List<User>>() {
        // });
        // System.out.println("JSON reads successfully");
        // for (User user : readedUsers) {
        // System.out.println(
        // "Id: " + user._id + " user with name: " + user.name + " also with this email:
        // " + user.email
        // + " is " + user.type);
        // }
        // } catch (IOException ex) {
        // System.out.println(ex.getMessage());
        // }

        sc.close();
    }

}