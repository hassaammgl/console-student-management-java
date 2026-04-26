package com.student.management.system;

import java.util.Scanner;

public class Menu {
    public int choice;

    private int getChoice(Scanner sc) {
        System.out.println("Select options");
        System.out.println("1) add users");
        System.out.println("2) delete users");
        System.out.println("3) update user");
        System.out.println("4) list users");
        System.out.println("5) statics");
        System.out.println("6) search");
        System.out.println("0) exit");
        return Integer.parseInt(sc.nextLine());
    }

    public Menu(Scanner sc) {
        while (true) {
            switch (getChoice(sc)) {
                case 0 -> {
                    System.out.println("Bye");
                    System.exit(0);
                }
                case 1 -> {
                    User user = Utils.getUser(sc);
                    Utils.writeDataToFile(user);
                }
                case 2 -> Utils.deleteUser(sc);
                case 3 -> Utils.updateUser(sc);
                case 4 -> Utils.listUsers();
                case 5 -> Utils.listUsers();
                case 6 -> Utils.listUsers();
                default -> System.out.println("Wrong choice");
            }
        }
    }
}
