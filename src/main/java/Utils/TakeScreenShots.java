package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Attachment;
import java.io.File;
import java.io.IOException;


public class TakeScreenShots {
    @Attachment(value = "Screenshot", type = "image/png")
        public static byte[] takeScreen(WebDriver driver, String fileName){
//            File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(screenshotFile,new File("ScreenShots/",fileName+".png"));
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    }

