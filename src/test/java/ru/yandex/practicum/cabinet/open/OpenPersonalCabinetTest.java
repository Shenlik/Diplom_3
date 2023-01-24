package ru.yandex.practicum.cabinet.open;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.DriverConfig;
import ru.yandex.practicum.api.ClientUser;
import ru.yandex.practicum.pageobject.InputPage;
import ru.yandex.practicum.pageobject.MainPage;
import ru.yandex.practicum.dto.CreateUserRequest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.DriverConfig.CHROME;

public class OpenPersonalCabinetTest {
    private RemoteWebDriver driver;
    private CreateUserRequest user;
    private String token;

    public OpenPersonalCabinetTest() {
        var browser = System.getProperties().getProperty("webbrowser", CHROME);
        this.driver = DriverConfig.getDriver(browser);
    }

    @Before
    public void setUp() throws JsonProcessingException {
        new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        user = ClientUser.createUserRequest();
        token = ClientUser.createUser(user).getAccessToken();
    }

    @Test
    @Description("Тест проверяет переход по клику в Личный кабинет")
    public void checkSuccessOpenPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);

        mainPage
                .open()
                .clickLoginAccountButton();

        assertTrue(inputPage.isOnInputPage());
    }

    @After
    public void tearDown() {
        ClientUser.deleteUser(token);
        driver.quit();
    }
}



