package ru.yandex.practicum.sectionConstructor;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static ru.yandex.practicum.DriverConfig.YANDEX_OPTION;

public class YandexSectionConstructorTest extends SectionConstructorTest {

        public YandexSectionConstructorTest() {
            super(new ChromeDriver(YANDEX_OPTION));
        }

        @BeforeClass
        public static void setupDriver() {
            System.setProperty("webdriver.chrome.driver","/Users/user/Desktop/WebDriver/bin/chromedriver_108");
        }

    }

