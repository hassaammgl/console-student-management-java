package com.student.management.system;

public class User {

    private static int counter = 0;

    public int _id;
    public String name;
    public String email;
    public String type;

    public User() {
    }

    public User(String name, String email, String type) {
        counter++;
        this._id = counter;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public static void setCounter(int value) {
        counter = value;
    }

}