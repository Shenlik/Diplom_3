package ru.yandex.practicum.input;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.DriverConfig;
import ru.yandex.practicum.api.ClientUser;
import ru.yandex.practicum.pageobject.*;
import ru.yandex.practicum.dto.CreateUserRequest;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.DriverConfig.*;

public class InputTest {
    private final RemoteWebDriver driver;

    private CreateUserRequest user;
    private String token;

    public InputTest() {
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
    @Description("Тест проверяет  вход через кнопку «Войти в аккаунт»")
    public void checkInputByPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);

        mainPage
                .open()
                .clickPersonalAccountButton();

        inputPage
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickEnterButton();

        assertTrue(mainPage.isOnMainPage());
    }

    @Test
    @Description("Тест проверяет  вход через кнопку «Личный кабинет»")
    public void checkInputByLoginAccountButton() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);

        mainPage
                .open()
                .clickLoginAccountButton();
        inputPage
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickEnterButton();

        assertTrue(mainPage.isOnMainPage());
    }

    @Test
    @Description("Тест проверяет  вход через кнопку в форме регистрации")
    public void checkInputByRegistration() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver) {
        };

        mainPage
                .open()
                .clickLoginAccountButton();
        inputPage
                .clickSignUpLink();
        registrationPage
                .clickLoginLink();
        inputPage
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickEnterButton();

        assertTrue(mainPage.isOnMainPage());
    }

    @Test
    @Description("Тест проверяет  вход через кнопку в форме восстановления пароля")
    public void checkInputByRecoverPassword() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);

        mainPage
                .open()
                .clickLoginAccountButton();
        inputPage
                .clickRecoverPasswordLinkLink();
        recoverPasswordPage
                .clickLoginLink();
        inputPage
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickEnterButton();

        assertTrue(mainPage.isOnMainPage());
    }

    @After
    public void tearDown() {
        ClientUser.deleteUser(token);
        driver.quit();
    }
}