package ru.yandex.practicum.input;

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

public abstract class InputTest {
    private final RemoteWebDriver driver;

    private CreateUserRequest user;
    private String token;

    public InputTest(RemoteWebDriver driver) {
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