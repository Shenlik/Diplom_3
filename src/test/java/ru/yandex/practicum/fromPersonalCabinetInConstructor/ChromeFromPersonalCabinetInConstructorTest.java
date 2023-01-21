package ru.yandex.practicum.fromPersonalCabinetInConstructor;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.practicum.DriverConfig.CHROME_OPTION;

public class ChromeFromPersonalCabinetInConstructorTest extends FromPersonalCabinetInConstructorTest {
        public ChromeFromPersonalCabinetInConstructorTest() {
            super(new ChromeDriver(CHROME_OPTION));
        }


        @BeforeClass
        public static void setupDriver() {
            System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/WebDriver/bin/chromedriver");
        }

    }

