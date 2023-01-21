package ru.yandex.practicum.openPersinalCabinet;

import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pageobject.InputPage;
import ru.yandex.practicum.pageobject.MainPage;
import ru.yandex.practicum.pageobject.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public abstract class OpenPersonalCabinetTest {
    private RemoteWebDriver driver;

    private String email;
    private String password;

    public OpenPersonalCabinetTest(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void setUp() {
        new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage
                .open()
                .clickLoginAccountButton();

        inputPage
                .clickSignUpLink();

        email = RandomStringUtils.randomAlphabetic(6) + "@mail.ru";
        password = "qwerty";
        registrationPage
                .fillNameField("lika")
                .fillEmailField(email)
                .fillPasswordField(password)
                .clickSignUpButton();
    }

    @Test
    @Description("Тест проверяет переход по клику в Личный кабинет")
    public void checkSuccessOpenPersonalAccount()  {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);

        mainPage
                .open()
                .clickLoginAccountButton();


        assertTrue(inputPage.isOnInputPage());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



