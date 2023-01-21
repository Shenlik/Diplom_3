package ru.yandex.practicum.input;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.practicum.DriverConfig.YANDEX_OPTION;

public class YandexInputTest extends InputTest {

    public YandexInputTest() {
        super(new ChromeDriver(YANDEX_OPTION));
    }

    @BeforeClass
    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/user/Desktop/WebDriver/bin/chromedriver_108");
    }

}
