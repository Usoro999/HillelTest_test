package ToolsQATests;

import Config.BaseTest;
import ToolsQAPages.iFramePage;
import org.junit.Test;
import org.junit.*;

public class iFrameTest extends BaseTest {
    iFramePage iFramePage = new iFramePage(driver);
    @Test
    public void checkTextOnFrame1(){
        driver.get("https://demoqa.com/frames");
        Assert.assertEquals("Frames", iFramePage.getHeaderText());
        iFramePage.switchToFrame0();

        Assert.assertTrue(iFramePage.checkVisibilityOfIFrame());
        Assert.assertEquals("This is a sample page",iFramePage.getTextFromiFrame());


        iFramePage.switchToDefaultContent();
        Assert.assertEquals("Frames", iFramePage.getHeaderText());

    }
}
