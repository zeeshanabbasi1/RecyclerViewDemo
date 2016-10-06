package com.zta.recyclerviewdemo.Model;

/**
 * Created by Zee Abbasi on 9/29/2016.
 */

public class NameItem {

    String firstName;
    String lastName;

    public NameItem(){}

    public NameItem(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
