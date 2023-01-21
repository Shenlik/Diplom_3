package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    // Поле имя
    private final By nameField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // Поле почты
    private final By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // Поле пароль
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");

    // Кнопка "Регистрация"
    private final By signUpButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    // Ссылка "Войти" в центре страницы
    private final By loginLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    // Сообщение об ошибке "Некорректный пароль"
    private final By incorrectPasswordTitle = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");


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
