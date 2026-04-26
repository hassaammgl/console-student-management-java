package com.student.management.system;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utils.initializeCounter();
        new Menu(sc);
        sc.close();
    }

}