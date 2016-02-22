package com.miguelcr.optionsmenu;

/**
 * Created by miguelcampos on 22/2/16.
 */
public class Student {
    private int avatar, age;
    private String name;

    public Student(int avatar, int age, String name) {
        this.avatar = avatar;
        this.age = age;
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
