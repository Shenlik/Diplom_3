package ru.yandex.practicum.logOutOfAccount;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.practicum.DriverConfig.CHROME_OPTION;

public class ChromeLogOutOfAccountTest extends LogOutOfAccountTest {
    public ChromeLogOutOfAccountTest() {
        super(new ChromeDriver(CHROME_OPTION));
    }


    @BeforeClass
    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/WebDriver/bin/chromedriver");
    }

}

