package TestNgConfigurations;

import Config.BROWSERS;
import Config.DriverConfig;
import org.openqa.selenium.WebDriver
        ;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestTestNG {
    protected static WebDriver driver;



    @BeforeClass
    public void createDriver(){
        driver = DriverConfigTestNG.createDriver(BROWSERS.CHROMEPROXY);
    }

    @AfterClass
    public void closeDriver(){
        if(driver != null){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.quit();
        }
    }
}

