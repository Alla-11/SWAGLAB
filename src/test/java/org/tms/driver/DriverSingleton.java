package org.tms.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Log4j2
public class DriverSingleton {
    private static WebDriver driver;

    public DriverSingleton() {
    }

    public static WebDriver getDriver(){
        if (driver == null){
            switch (System.getProperty("browser")){
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default:{
                    try {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }catch (Exception e){
                        log.fatal("Fatal: Driver did not start!");
                    }
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
