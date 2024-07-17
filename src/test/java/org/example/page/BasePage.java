package org.example.page;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {

    public void scrollToElement(By startOrderButtonBy) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(startOrderButtonBy));
    }

    public void waitForVisibilityOfElement(WebDriver driver, By element) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean isElementDisplayed(String xPathPanelFull) {
        return driver.findElement(By.xpath(xPathPanelFull)).isDisplayed();
    }
}
