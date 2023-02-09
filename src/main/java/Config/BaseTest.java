package Config;

import net.lightbody.bmp.BrowserMobProxyServer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver;



    @BeforeClass
    public static void createDriver(){
        driver = DriverConfig.createDriver(BROWSERS.CHROMEINCOGNITO);
    }

    @AfterClass
    public static void closeDriver(){
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

