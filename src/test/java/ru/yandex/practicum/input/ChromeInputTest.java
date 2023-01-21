package ru.yandex.practicum.input;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.practicum.DriverConfig.CHROME_OPTION;

public class ChromeInputTest extends InputTest {
        public ChromeInputTest() {
            super(new ChromeDriver(CHROME_OPTION));
        }


        @BeforeClass
        public static void setupDriver() {
            System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/WebDriver/bin/chromedriver");
        }

    }



