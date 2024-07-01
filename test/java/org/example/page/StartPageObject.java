package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPageObject {
    public WebDriver driver;
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Первая кнопка "Заказать"
    public static By firstButton = By.xpath("//button[@class='Button_Button__ra12g']");
    //Вторая кнопка "Заказать"
    public static By secondButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Элемент выпадающего списка со стрелкой для нажатия
    public String xpathHeading = ".//div[@id='accordion__heading-";
    //Элемент выпадающий после нажатия кнопки
    public String xpathPanel = ".//div[@id='accordion__panel-";

    public StartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //Ожидаем, пока элемент станет видимчм
    public void waitForVisibilityOfElement(WebDriver driver, By element) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean isElementDisplayed(String xPathPanelFull) {
        return driver.findElement(By.xpath(xPathPanelFull)).isDisplayed();
    }
}
