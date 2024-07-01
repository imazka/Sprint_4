package org.example.test_of_order_of_scooter;

import org.openqa.selenium.By;

public class User {
    private String name;
    private String surname;
    private String adress;
    private String metroStation;
    private String phone;
    private By orderButton;

    public User(String name, String surname, String adress, String metroStation, String phone, By orderButton) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phone = phone;
        this.orderButton = orderButton;
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

    public By getOrderButton() {
        return orderButton;
    }
}
