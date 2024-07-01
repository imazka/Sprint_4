package org.example.test_of_order_of_scooter;

import org.example.BaseTest;
import org.example.page.OrderPageObject;
import org.example.page.StartPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.example.page.StartPageObject.firstButton;
import static org.example.page.StartPageObject.secondButton;

/**
 * Тест заказа самоката
 */
@RunWith(Parameterized.class)
public class OrderOfScooterTest extends BaseTest {
    User user;

    public OrderOfScooterTest(User user) {
        this.user = user;
    }

    @Parameterized.Parameters
    public static List<User> getCapabilities() {
        List<User> userList = new ArrayList<>();
        //Генерируем тестовые данные
        userList.add(new User("Виктор", "Васильев", "г. Москва, ул. Пресненская набережная, д. 8", "Комсомольская", "+79467564354", firstButton));
        userList.add(new User("Алексей", "Виноградов", "г. Москва, ул. Фрунзе, д. 5, кв. 1", "Фрунзенская", "+79264758623", secondButton));

        return userList;
    }

    //Запуск драйвера и открытие стартовой страницы
    @Before
    public void setUpDriver() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.manage().window().maximize();
        //Установка времени ожидания для каждого элемента в коде
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(StartPageObject.URL);
        //Установка куки
        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
        driver.navigate().refresh();
    }

    @Test
    public void orderingOfScooter() {

        OrderPageObject orderPageObject = new OrderPageObject(driver);

        //Скролл до кнопки "Заказать"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(user.getOrderButton()));
        //Клик по кнопке "Заказать"
        driver.findElement(user.getOrderButton()).click();
        //Ввод данных в поля
        driver.findElement(orderPageObject.name).sendKeys(user.getName());
        driver.findElement(orderPageObject.surname).sendKeys(user.getSurname());
        driver.findElement(orderPageObject.adress).sendKeys(user.getAdress());
        driver.findElement(orderPageObject.metroStationInputField).sendKeys(user.getMetroStation());
        //Клик по элементу выпадающего списка
        driver.findElement(By.className("select-search__row")).click();
        //Ввод данных в поле "Телефон"
        driver.findElement(orderPageObject.phone).sendKeys(user.getPhone());
        //Клик по кнопке "Далее"
        driver.findElement(orderPageObject.buttonGo).click();
        //Клик по полю с датой
        driver.findElement(orderPageObject.date).click();
        //Клик по дате в выпадающем окошке
        driver.findElement(orderPageObject.datePicker).click();
        //Клик по полю "Срок аренды"
        driver.findElement(orderPageObject.daysOfArend).click();
        //Клик по элементу в выпадающем списке
        driver.findElement(orderPageObject.daysOfArendDropDownOption).click();
        //Клик по элементу "чёрный жемчуг"
        driver.findElement(orderPageObject.color).click();
        //Ввод в поле "Коментарий курьеру"
        driver.findElement(orderPageObject.comment).sendKeys(orderPageObject.textForCourier);
        //Клик по кнопке "Заказать"
        driver.findElement(orderPageObject.buttonStartOrder).click();
        //Клик по кнопке "Да"
        driver.findElement(orderPageObject.buttonYes).click();
        //Проверка появления информации о статусе заказа
        driver.findElement(orderPageObject.orderStartedText);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
