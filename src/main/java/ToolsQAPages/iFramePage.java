package ToolsQAPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class iFramePage {
    public WebDriver driver;

    public iFramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(className = "main-header")
    WebElement header;
    @FindBys(@FindBy(id = "sampleHeading"))
    List<WebElement> iFramesList;
    @CacheLookup
    @FindBy(xpath = "//h1[@id = 'sampleHeading']")
    WebElement iFrameOne;

    public String getHeaderText() {
        return header.getText();
    }

    public Boolean checkVisibilityOfIFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOf(iFrameOne)).isEnabled();


    }

    public void switchToFrame0(){
        driver.switchTo().frame(0);

    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public String getTextFromiFrame(){
        return iFrameOne.getText();
    }
}
