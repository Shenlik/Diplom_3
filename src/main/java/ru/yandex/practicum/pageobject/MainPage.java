package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class MainPage {

    private final String url = "https://stellarburgers.nomoreparties.site/";

    // Заголовок раздела "Булки"
    private final By bunTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]");

    // Заголовок раздела "Соусы"
    private final By sauceTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]");

    // Заголовок раздела "Начинки"
    private final By toppingTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]");

    // Кнопка "Личный кабинет" вверху страницы
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");


    // Кнопка "Войти в аккаунт" в центре страницы
    private final By logInAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // Раздел Булки в Конструкторе "Соберите бургер"
    private final By bunSection = By.xpath(".//h2[text()='Булки']");

    // Раздел Соусы в Конструкторе "Соберите бургер"
    private final By sauceSection = By.xpath(".//h2[text()='Соусы']");

    // Раздел Начинки в Конструкторе "Соберите бургер"
    private final By toppingSection = By.xpath(".//h2[text()='Начинки']");







    // Драйвер браузера
    private final RemoteWebDriver driver;
    private final WebDriverWait wait;

    public MainPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public By getBunTitle() {
        return bunTitle;
    }

    public By getSauceTitle() {
        return sauceTitle;
    }

    public By getToppingTitle() {
        return toppingTitle;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
        return this;
    }

    public MainPage clickLoginAccountButton() {
        driver.findElement(logInAccountButton).click();
        return this;
    }

    public MainPage clickSauceSection() {
        if (!isSectionSelected(sauceSection)) {
            driver.findElement(sauceSection).click();
        }
        return this;
    }

    public MainPage clickToppingSection() {
        if (!isSectionSelected(toppingSection)) {
            driver.findElement(toppingSection).click();
        }
        return this;
    }

    public MainPage clickBunSection() {
        if (!isSectionSelected(bunSection)) {
            driver.findElement(bunSection).click();
        }
        return this;
    }

    private boolean isSectionSelected(By element) {
        return driver.findElement(element).getAttribute("class").contains("current");
    }

    public boolean isOnMainPage() {
        wait.until(ExpectedConditions.urlMatches(".*stellarburgers.nomoreparties.site"));
        return true;
    }


    public boolean isBunVisible() {
        return driver.findElement(bunTitle).isDisplayed();
    }

    public boolean isSauceVisible() {
        return driver.findElement(sauceTitle).isDisplayed();
    }

    public boolean isToppingVisible() {
        return driver.findElement(toppingTitle).isDisplayed();
    }

}
