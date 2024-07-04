package org.example.page;

import org.openqa.selenium.By;

public class OrderPageObject extends BasePage {

    private By name = By.xpath(".//input[@placeholder='* Имя']");
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private By adress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationInputField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonGo = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By datePicker = By.xpath(".//div[contains(@class, 'react-datepicker__day') and text()='25']");
    private By daysOfArend = By.className("Dropdown-placeholder");
    private By daysOfArendDropDownOption = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    private By color = By.xpath(".//label[@for='black']");
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By buttonStartOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By orderStartedHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private String orderStartedText = "Заказ оформлен";
    private By selectMetroStation = By.className("select-search__row");

    public String getOrderStartedHeaderText() {
        return driver.findElement(orderStartedHeader).getText();
    }

    public String getOrderStartedText() {
        return orderStartedText;
    }

    public void setNameField(String nameFromParams) {
        driver.findElement(name).sendKeys(nameFromParams);
    }

    public void setSurnameField(String surnameFromParams) {
        driver.findElement(surname).sendKeys(surnameFromParams);
    }

    public void setAdressField(String adressFromParams) {
        driver.findElement(adress).sendKeys(adressFromParams);
    }

    public void setMetroStationField(String metroStationFromParams) {
        driver.findElement(metroStationInputField).sendKeys(metroStationFromParams);
        //Клик по элементу выпадающего списка
        driver.findElement(selectMetroStation).click();
    }

    public void setPhoneField(String phoneFromParams) {
        driver.findElement(phone).sendKeys(phoneFromParams);
    }

    public void clickGoButton() {
        driver.findElement(buttonGo).click();
    }

    public void setDateField() {
        //Клик по полю с датой
        driver.findElement(date).click();
        //Клик по дате в выпадающем окошке
        driver.findElement(datePicker).click();
    }

    public void setDaysOfArendField() {
        //Клик по полю "Срок аренды"
        driver.findElement(daysOfArend).click();
        //Клик по элементу в выпадающем списке
        driver.findElement(daysOfArendDropDownOption).click();
    }

    public void setColour() {
        driver.findElement(color).click();
    }

    public void setCommentField(String commentFromParams) {
        driver.findElement(comment).sendKeys(commentFromParams);
    }

    public void clickOrderStartButton() {
        driver.findElement(buttonStartOrder).click();
    }

    public void clickYesButton() {
        driver.findElement(buttonYes).click();
    }
}
