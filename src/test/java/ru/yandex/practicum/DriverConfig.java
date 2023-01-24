package ru.yandex.practicum;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverConfig {

    public static ChromeOptions YANDEX_OPTION;
    public static ChromeOptions CHROME_OPTION;

    public static final String YANDEX = "yandex";
    public static final String CHROME = "chrome";

    public static final String DRIVER_PATH = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_PATH = "/Users/user/Desktop/WebDriver/bin/chromedriver";
    public static final String YANDEX_DRIVER_PATH = "/Users/user/Desktop/WebDriver/bin/chromedriver_108";


    static {
        YANDEX_OPTION = new ChromeOptions();
        YANDEX_OPTION.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        YANDEX_OPTION.addArguments("--headless");

        CHROME_OPTION = new ChromeOptions();
        CHROME_OPTION.addArguments("--headless");
    }

    public static RemoteWebDriver getDriver(String browser) {
        if (CHROME.equalsIgnoreCase(browser)) {
            System.setProperty(DRIVER_PATH, CHROME_DRIVER_PATH);
            return new ChromeDriver(CHROME_OPTION);
        } else if (YANDEX.equalsIgnoreCase(browser)) {
            System.setProperty(DRIVER_PATH, YANDEX_DRIVER_PATH);
            return new ChromeDriver(YANDEX_OPTION);
        } else {
            throw new IllegalArgumentException("Browser not found: " + browser);
        }
    }
}
