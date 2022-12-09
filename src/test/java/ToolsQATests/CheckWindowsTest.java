package ToolsQATests;

import Config.BaseTest;
import ToolsQAPages.HandleWindowsPage;
import org.junit.Assert;
import org.junit.Test;

public class CheckWindowsTest extends BaseTest {
    HandleWindowsPage handleWindowsPage = new HandleWindowsPage(driver);

    @Test
    public void checkTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        handleWindowsPage.clickTubButton();
        handleWindowsPage.switchToChildWindow();
        Assert.assertEquals("This is a sample page",handleWindowsPage.getNewWindowText());
        System.out.println(handleWindowsPage.getNewWindowText());
        Thread.sleep(4000);

        handleWindowsPage.switchToMainWindow();
        Assert.assertEquals("Browser Windows",handleWindowsPage.getMainWindowText());
        System.out.println(handleWindowsPage.getMainWindowText());

    }
}
