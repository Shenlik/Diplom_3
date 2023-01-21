package ru.yandex.practicum.fromPersonalCabinetInConstructor;

import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pageobject.InputPage;
import ru.yandex.practicum.pageobject.MainPage;
import ru.yandex.practicum.pageobject.PersonalCabinetPage;
import ru.yandex.practicum.pageobject.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

//Переход из личного кабинета в конструктор
//Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
public abstract class FromPersonalCabinetInConstructorTest {

    private final RemoteWebDriver driver;

    private String email;
    private String password;

    public FromPersonalCabinetInConstructorTest(RemoteWebDriver driver) {
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
    @Description("Тест проверяет переход по клику Конструктор из Личного кабинета")
    public void checkClickOnConstructor() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);

        mainPage
                .open()
                .clickPersonalAccountButton();

        inputPage
                .fillEmailField(email)
                .fillPasswordField(password)
                .clickEnterButton();
        mainPage
                .clickPersonalAccountButton();
        personalCabinetPage
                .clickConstructorButton();

        assertTrue(mainPage.isOnMainPage());
    }

    @Test
    @Description("Тест проверяет переход по клику логотипа из Личного кабинета")
    public void checkClickOnLogo() {
        MainPage mainPage = new MainPage(driver);
        InputPage inputPage = new InputPage(driver);
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);

        mainPage
                .open()
                .clickPersonalAccountButton();

        inputPage
                .fillEmailField(email)
                .fillPasswordField(password)
                .clickEnterButton();
        mainPage
                .clickPersonalAccountButton();
        personalCabinetPage
                .clickLogoButton();

        assertTrue(mainPage.isOnMainPage());
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
