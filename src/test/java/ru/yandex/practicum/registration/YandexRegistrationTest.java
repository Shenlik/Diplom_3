package ru.yandex.practicum.registration;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.sectionConstructor.SectionConstructorTest;

import static ru.yandex.practicum.DriverConfig.YANDEX_OPTION;

public class YandexRegistrationTest extends RegistrationTest{

        public YandexRegistrationTest() {
                super(new ChromeDriver(YANDEX_OPTION));
        }

        @BeforeClass
        public static void setupDriver() {
                System.setProperty("webdriver.chrome.driver","/Users/user/Desktop/WebDriver/bin/chromedriver_108");
        }

}
