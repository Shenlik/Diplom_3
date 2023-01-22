package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    // Поле имя
    private final By nameField = By.xpath("//label[text()='Имя']/../input");

    // Поле почты
    private final By emailField = By.xpath("//label[text()='Email']/../input");

    // Поле пароль
    private final By passwordField = By.xpath("//label[text()='Пароль']/../input");

    // Кнопка "Регистрация"
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // Ссылка "Войти" в центре страницы
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    // Сообщение об ошибке "Некорректный пароль"
    private final By incorrectPasswordTitle = By.xpath(".//p[text()='Некорректный пароль']");


    // Драйвер браузера
    private final RemoteWebDriver driver;
    private final WebDriverWait wait;

    public RegistrationPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public RegistrationPage fillNameField(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(text);
        return this;
    }

    public RegistrationPage fillEmailField(String text) {

        driver.findElement(emailField).sendKeys(text);
        return this;
    }

    public RegistrationPage fillPasswordField(String text) {

        driver.findElement(passwordField).sendKeys(text);
        return this;
    }

    public RegistrationPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return this;
    }

    public RegistrationPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return this;
    }

    public boolean isPasswordIncorrect() {
        return driver.findElement(incorrectPasswordTitle).isDisplayed();
    }

}
