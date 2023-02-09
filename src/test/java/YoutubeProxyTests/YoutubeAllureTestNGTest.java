package YoutubeProxyTests;

import Config.BaseProxy;
import Config.BaseTest;
import TestNgConfigurations.BaseProxyTestNG;
import Utils.TakeScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class YoutubeAllureTestNGTest extends BaseProxyTestNG {

    @Test(description = "Make screenshots", groups = {"smoke","regression"})
    public void testYoutube() throws InterruptedException {
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//div[contains(@class, 'mobile-topbar-header-content')]/button")).click();
        driver.findElement(By.xpath("//div[@class = 'searchbox-input-wrapper']/input[contains(@class, 'searchbox-input')]")).sendKeys("no war");
        driver.findElement(By.xpath("//div[@class = 'searchbox-input-wrapper']/input[contains(@class, 'searchbox-input')]")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        TakeScreenShots.takeScreen(driver, "screenShot");
    }

    @AfterClass
    public void closePage(){


        //Logs.printLogs(driver);
        //Logs.writeLogsToFile(driver, "noWar", Level.ALL);
    }
}
