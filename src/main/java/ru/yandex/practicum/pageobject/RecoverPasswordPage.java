package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RecoverPasswordPage {

    // Ссылка "Войти" в центре страницы
    private final By loginLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    // Драйвер браузера
    private final RemoteWebDriver driver;

    public RecoverPasswordPage(RemoteWebDriver driver) {
        this.driver = driver;
    }
        public RecoverPasswordPage clickLoginLink() {
            driver.findElement(loginLink).click();
            return this;
    }
}
