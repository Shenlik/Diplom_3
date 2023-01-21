package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class InputPage {

    // Поле почты
    private final By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // Поле пароль
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // Кнопка "Регистрация"
    private final By EnterButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    // Ссылка "Зарегистрироваться" в центре страницы
    private final By signUpLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");

    // Ссылка "Восстановить пароль" в центре страницы
    private final By recoverPasswordLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");

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
        wait.until(ExpectedConditions.urlMatches(".*stellarburgers.nomoreparties.site/login"));
        return true;
    }


}
