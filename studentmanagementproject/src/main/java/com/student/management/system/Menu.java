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
        System.out.println("0) exit");
        return sc.nextInt();
    }

    public Menu(Scanner sc) {
        switch (getChoice(sc)) {
            case 0:
                System.exit(0);
                break;
            case 1:
                Utils.getUser(sc);
            case 2:
                Utils.getUser(sc);
            case 3:
                Utils.getUser(sc);
            case 4:
                Utils.listUsers();
            default:
                break;
        }
    }
}
