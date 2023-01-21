package ru.yandex.practicum.registration;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.practicum.DriverConfig.CHROME_OPTION;

public class ChromeRegistrationTest extends RegistrationTest{

    public ChromeRegistrationTest() {
        super(new ChromeDriver(CHROME_OPTION));
    }


    @BeforeClass
    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/WebDriver/bin/chromedriver");
    }

}
