package YoutubeProxyTests;

import Config.BaseProxy;
import Utils.TakeScreenShots;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class YoutubeTest extends BaseProxy {

    @BeforeClass
    public static void openPage(){
        driver.get("https://www.youtube.com/");

    }

    @Test
    public void testYoutube() throws InterruptedException {

        driver.findElement(By.xpath("//div[contains(@class, 'mobile-topbar-header-content')]/button")).click();
        driver.findElement(By.xpath("//div[@class = 'searchbox-input-wrapper']/input[contains(@class, 'searchbox-input')]")).sendKeys("no war");
        driver.findElement(By.xpath("//div[@class = 'searchbox-input-wrapper']/input[contains(@class, 'searchbox-input')]")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        TakeScreenShots.takeScreen(driver, "screenShot");
    }

    @AfterClass
    public static void closePage(){


        //Logs.printLogs(driver);
        //Logs.writeLogsToFile(driver, "noWar", Level.ALL);
    }
}
