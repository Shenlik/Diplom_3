package ru.yandex.practicum.openPersonalCabinet;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.practicum.DriverConfig.YANDEX_OPTION;

public class YandexOpenPersonalCabinetTest extends OpenPersonalCabinetTest {

    public YandexOpenPersonalCabinetTest() {
        super(new ChromeDriver(YANDEX_OPTION));
    }

    @BeforeClass
    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/user/Desktop/WebDriver/bin/chromedriver_108");
    }


}
