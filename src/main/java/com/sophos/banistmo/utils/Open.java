package com.sophos.banistmo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class Open {
    private static String downloadFilepath = "C:\\Users\\Juan.raga\\semillero0621\\Banistmo\\src\\main\\java\\com\\sophos\\banistmo\\assets";
    private static WebDriver driver;
    private static String baseUrl = "https://www.banistmo.com/wps/portal/banistmo/personas/";

    public static WebDriver url() {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/banistmo/drivers/chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", downloadFilepath);


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.navigate().to(baseUrl);
        return driver;
    }

}
