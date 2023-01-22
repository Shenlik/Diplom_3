package ru.yandex.practicum.registration;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pageobject.ClientUser;
import ru.yandex.practicum.pageobject.InputPage;
import ru.yandex.practicum.pageobject.MainPage;
import ru.yandex.practicum.pageobject.RegistrationPage;
import ru.yandex.practicum.pageobject.dto.CreateUserRequest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public abstract class RegistrationTest {

    private final RemoteWebDriver driver;
    private CreateUserRequest user;
    private String name;
    private String email;
    private String password;

    public RegistrationTest(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void setUp() {
        new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    @Description("Тест проверяет успешную регистрацию")
    public void checkSuccessfulRegistration() throws JsonProcessingException {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage
                .open()
                .clickLoginAccountButton();

        inputPage
                .clickSignUpLink();

        name = "Anzhelika";
        email = RandomStringUtils.randomAlphabetic(6) + "@mail.ru";
        password = "qwerty";


        registrationPage
                .fillNameField(name)
                .fillEmailField(email)
                .fillPasswordField(password)
                .clickSignUpButton();

        inputPage
                .fillEmailField(email)
                .fillPasswordField(password)
                .clickEnterButton();

        assertTrue(mainPage.isOnMainPage());
    }

    @Test
    @Description("Тест проверяет ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void checkErrorByWrongPassword() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage
                .open()
                .clickLoginAccountButton();

        inputPage
                .clickSignUpLink();

        name = "Anzhelika";
        email = RandomStringUtils.randomAlphabetic(6) + "@mail.ru";
        password = "qwert";

        registrationPage
                .fillNameField(name)
                .fillEmailField(email)
                .fillPasswordField(password)
                .clickSignUpButton();

        Assert.assertTrue(registrationPage.isPasswordIncorrect());
    }

    @After
    public void tearDown() throws JsonProcessingException {
        var userResponse = ClientUser.loginUser(email, password);
        if (userResponse.getAccessToken() != null) {
            ClientUser.deleteUser(userResponse.getAccessToken());
        }
        driver.quit();
    }
}