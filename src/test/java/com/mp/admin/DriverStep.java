package com.mp.admin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverStep {
    public static DriverStep driverStep = null;
    public WebDriver driver;

    private DriverStep(){
        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        //Commented
    }

    public static DriverStep getInstance(){
        if(driverStep==null) {
            driverStep = new DriverStep();
        }
            return driverStep;
    }
    public WebDriver getDriver(){
        return driver;
    }

}
