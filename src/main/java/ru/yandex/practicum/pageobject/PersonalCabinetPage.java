package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

// Кнопка "Личный кабинет"
public class PersonalCabinetPage {

    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");

    // Логотип "Stellar burgers"
    private final By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");


    // Кнопка "Выйти"
    private final By exitButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");


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
