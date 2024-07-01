package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageObject extends StartPageObject {

    public By name = By.xpath(".//input[@placeholder='* Имя']");
    public By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    public By adress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public By metroStationInputField = By.xpath(".//input[@placeholder='* Станция метро']");
    public By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public By buttonGo = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public By datePicker = By.xpath(".//div[contains(@class, 'react-datepicker__day') and text()='25']");
    public By daysOfArend = By.className("Dropdown-placeholder");
    public By daysOfArendDropDownOption = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    public By color = By.xpath(".//label[@for='black']");
    public By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public By buttonStartOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    public By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    public By orderStartedText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    public String textForCourier = "Домофон не работает";

    public OrderPageObject(WebDriver driver) {
        super(driver);
    }
}
