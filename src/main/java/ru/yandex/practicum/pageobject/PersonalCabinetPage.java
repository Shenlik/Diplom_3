package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

// Кнопка "Личный кабинет"
public class PersonalCabinetPage {

    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    // Логотип "Stellar burgers"
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");


    // Кнопка "Выйти"
    private final By exitButton = By.xpath(".//button[text()='Выход']");


    // Драйвер браузера
    private final RemoteWebDriver driver;

    public PersonalCabinetPage(RemoteWebDriver driver) {
        this.driver = driver;

    }

    public PersonalCabinetPage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return this;
    }

    public PersonalCabinetPage clickLogoButton() {
        driver.findElement(logoButton).click();
        return this;
    }


    public PersonalCabinetPage clickExitButton() {
        driver.findElement(exitButton).click();
        return this;
    }

}
