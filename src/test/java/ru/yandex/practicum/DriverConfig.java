package ru.yandex.practicum;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfig {

    public static ChromeOptions YANDEX_OPTION;
    public static ChromeOptions CHROME_OPTION;

    static {
        YANDEX_OPTION = new ChromeOptions();
        YANDEX_OPTION.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        YANDEX_OPTION.addArguments("--headless");

        CHROME_OPTION = new ChromeOptions();
        CHROME_OPTION.addArguments("--headless");
    }
}
