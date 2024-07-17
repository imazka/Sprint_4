package org.example.test.oderscooter;

import org.openqa.selenium.By;

public class User {
    private String name;
    private String surname;
    private String adress;
    private String metroStation;
    private String phone;
    private int number;
    private String comment;

    public User(String name, String surname, String adress, String metroStation, String phone, int number, String comment) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phone = phone;
        this.number = number;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumber() {
        return number;
    }
}
