package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputPage {

    public static final String STELLARBURGERS_LOGIN_URL_PATTERN = ".*stellarburgers.nomoreparties.site/login";
    // Поле почты
    private final By emailField = By.xpath("//label[text()='Email']/../input");

    // Поле пароль
    private final By passwordField = By.xpath("//label[text()='Пароль']/../input");

    // Кнопка "Войти"
    private final By EnterButton = By.xpath(".//button[text()='Войти']");

    // Ссылка "Зарегистрироваться" в центре страницы
    private final By signUpLink = By.xpath("//a[@class=\"Auth_link__1fOlj\"][text()=\"Зарегистрироваться\"]");

    // Ссылка "Восстановить пароль" в центре страницы
    private final By recoverPasswordLink = By.xpath("//a[@class=\"Auth_link__1fOlj\"][text()=\"Восстановить пароль\"]");

    // Драйвер браузера
    private final RemoteWebDriver driver;
    private final WebDriverWait wait;

    public InputPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public InputPage fillEmailField(String text) {
        wait.until(ExpectedConditions.urlContains("login"));
        driver.findElement(emailField).sendKeys(text);
        return this;
    }

    public InputPage fillPasswordField(String text) {
        driver.findElement(passwordField).sendKeys(text);
        return this;
    }

    public InputPage clickEnterButton() {
        driver.findElement(EnterButton).click();
        return this;
    }

    public InputPage clickSignUpLink() {
        driver.findElement(signUpLink).click();
        return this;
    }

    public InputPage clickRecoverPasswordLinkLink() {
        driver.findElement(recoverPasswordLink).click();
        return this;
    }

    public boolean isOnInputPage() {
        wait.until(ExpectedConditions.urlMatches(STELLARBURGERS_LOGIN_URL_PATTERN));
        return true;
    }


}
