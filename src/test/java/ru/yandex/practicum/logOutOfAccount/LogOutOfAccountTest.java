package ru.yandex.practicum.logOutOfAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pageobject.*;
import ru.yandex.practicum.pageobject.dto.CreateUserRequest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public abstract class LogOutOfAccountTest {
    private final RemoteWebDriver driver;
    private CreateUserRequest user;
    private String token;

    public LogOutOfAccountTest(RemoteWebDriver driver) {
        this.driver = driver;
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
    @Description("Тест проверяет выход в личном кабинете")
    public void checkExitButton()  {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);

        mainPage
                .open()
                .clickPersonalAccountButton();

        inputPage
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickEnterButton();
        mainPage
                .clickPersonalAccountButton();
        personalCabinetPage
                .clickExitButton();

        assertTrue(inputPage.isOnInputPage());
    }

    @After
    public void tearDown() {
        ClientUser.deleteUser(token);
        driver.quit();
    }
}
