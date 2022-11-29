package Config;

import Config.BROWSERS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverConfig {
    public static WebDriver driver;


    public static WebDriver createDriver(BROWSERS browsers) {
        switch (browsers){
            case CHROMEINCOGNITO -> createChrome();
            case FIREFOX -> createFirefox();
        }
        return driver;
    }


    public static void createChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
    }
    public static void createFirefox(){

    }
}