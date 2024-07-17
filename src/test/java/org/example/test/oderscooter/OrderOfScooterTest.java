package org.example.test.oderscooter;

import org.example.BaseTest;
import org.example.page.OrderPageObject;
import org.example.page.StartPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Тест заказа самоката
 */
@RunWith(Parameterized.class)
public class OrderOfScooterTest extends BaseTest {
    User user;

    public OrderOfScooterTest(User user) {
        super();
        this.user = user;
    }

    @Parameterized.Parameters
    public static List<User> getParameters() {
        List<User> userList = new ArrayList<>();
        //Генерируем тестовые данные
        userList.add(new User("Виктор", "Васильев", "г. Москва, ул. Пресненская набережная, д. 8", "Комсомольская", "+79467564354", 1, "Домофон не работает"));
        userList.add(new User("Алексей", "Виноградов", "г. Москва, ул. Фрунзе, д. 5, кв. 1", "Фрунзенская", "+79264758623", 2,"Домофон работает"));

        return userList;
    }

    //Запуск драйвера и открытие стартовой страницы
    @Before
    public void setUpDriver() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "firefox" : driverType);
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

        StartPageObject startPageObject = new StartPageObject();

        //Скролл до кнопки "Заказать"
        startPageObject.scrollToElement(startPageObject.getButton(user.getNumber()));

        //Клик по кнопке "Заказать" и создание экземпляра следующей страницы
        OrderPageObject orderPageObject = startPageObject.clickStartOrderButton(startPageObject.getButton(user.getNumber()));

        //Ввод данных в поля
        orderPageObject.setNameField(user.getName());
        orderPageObject.setSurnameField(user.getSurname());
        orderPageObject.setAdressField(user.getAdress());
        orderPageObject.setMetroStationField(user.getMetroStation());

        //Ввод данных в поле "Телефон"
        orderPageObject.setPhoneField(user.getPhone());

        //Клик по кнопке "Далее"
        orderPageObject.clickGoButton();

        //Установка даты
        orderPageObject.setDateField();

        //Установка срока аренды
        orderPageObject.setDaysOfArendField();

        //Клик по элементу "чёрный жемчуг"
        orderPageObject.setColour();

        //Ввод в поле "Коментарий курьеру"
        orderPageObject.setCommentField(user.getComment());

        //Клик по кнопке "Заказать"
        orderPageObject.clickOrderStartButton();

        //Клик по кнопке "Да"
        orderPageObject.clickYesButton();

        //Проверка появления информации о статусе заказа
        assertTrue("Заказ не оформлен", orderPageObject.getOrderStartedHeaderText().contains(orderPageObject.getOrderStartedText()));
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
