package ru.yandex.practicum.sectionConstructor;

import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pageobject.InputPage;
import ru.yandex.practicum.pageobject.MainPage;
import ru.yandex.practicum.pageobject.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class SectionConstructorTest {
    private RemoteWebDriver driver;

    public SectionConstructorTest(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void setUp() {
        new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    @Description("Тест проверяет успешную переход в раздел Булки")
    public void checkSuccessfulOpenSectionBun() {
        MainPage mainPage = new MainPage(driver);
        var wait = new WebDriverWait(driver,30);

        mainPage.open();
        mainPage.clickBunSection();
        assertTrue(mainPage.isBunVisible());

        mainPage.clickSauceSection();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getSauceTitle()));

        mainPage.clickToppingSection();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getToppingTitle()));
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
