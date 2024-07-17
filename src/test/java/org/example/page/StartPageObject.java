package org.example.page;

import org.openqa.selenium.By;

public class StartPageObject extends BasePage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Первая кнопка "Заказать"
    public By firstButton = By.xpath("//button[@class='Button_Button__ra12g']");
    //Вторая кнопка "Заказать"
    public By secondButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Элемент выпадающего списка со стрелкой для нажатия
    public String xpathHeading = ".//div[@id='accordion__heading-";
    //Элемент выпадающий после нажатия кнопки
    public String xpathPanel = ".//div[@id='accordion__panel-";

    public void clickElementWithArrow(String elementWithArrow) {
        driver.findElement(By.xpath(elementWithArrow)).click();
    }


    public By getButton(int number) {
        return number % 2 == 0 ? firstButton : secondButton;
    }

    public OrderPageObject clickStartOrderButton (By startOrderButtonBy) {
        driver.findElement(startOrderButtonBy).click();
        return new OrderPageObject();
    }
}
