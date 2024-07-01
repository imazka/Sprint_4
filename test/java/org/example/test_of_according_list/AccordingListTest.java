package org.example.test_of_according_list;

import org.example.BaseTest;
import org.example.page.StartPageObject;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Тест списка "Вопросы о важном"
 */
@RunWith(Parameterized.class)
public class AccordingListTest extends BaseTest {
    private String expectedText;
    private String index;

    public AccordingListTest(String index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    //Запуск драйвера и открытие стартовой страницы
    @BeforeClass
    public static void setUp() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(StartPageObject.URL);
        //Установка куки
        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
        driver.navigate().refresh();
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"0", TextsForAccordingList.TEXT_1},
                {"1", TextsForAccordingList.TEXT_2},
                {"2", TextsForAccordingList.TEXT_3},
                {"3", TextsForAccordingList.TEXT_4},
                {"4", TextsForAccordingList.TEXT_5},
                {"5", TextsForAccordingList.TEXT_6},
                {"6", TextsForAccordingList.TEXT_7},
                {"7", TextsForAccordingList.TEXT_8},
        };
    }

    //Проверка текстов выпадающего списка
    @Test
    public void checkTextInAccordingListElements() {

        StartPageObject startPageObject = new StartPageObject(driver);
        //xPath для строки со стрелочкой
        String xPathHeadingFull = startPageObject.xpathHeading + index + "']";
        //xPath для выпадающего элемента с текстом
        String xPathPanelFull = startPageObject.xpathPanel + index + "']";
        //Ожидание видимости элемента со стрелочкой
        startPageObject.waitForVisibilityOfElement(driver, By.xpath(xPathHeadingFull));
        //Скролл к строке со стрелочкой
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xPathHeadingFull)));
        //Клик по элементу со стрелочкой
        driver.findElement(By.xpath(xPathHeadingFull)).click();
        //Проверка текста в появившемся элементе на соответствие заявленному и его видимость
        assertTrue(startPageObject.isElementDisplayed(xPathPanelFull));
        assertEquals("Выпадающий текст не совпадает с ожидаемым",
                expectedText, driver.findElement(By.xpath(xPathPanelFull)).getText());

    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
