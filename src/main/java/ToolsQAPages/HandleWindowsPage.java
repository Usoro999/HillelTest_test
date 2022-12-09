package ToolsQAPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class HandleWindowsPage {
    public WebDriver driver;

    public HandleWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;
    @FindBy(xpath = "//h1[@id = 'sampleHeading']")
    WebElement newWindowHeader;
    @FindBy(xpath = "//div[@class = 'main-header']")
    WebElement header;


    public void clickTubButton(){
        tabButton.click();
    }

    public void switchToChildWindow(){
        String parentWindow = driver.getWindowHandle();
        Set<String> listWindows = driver.getWindowHandles();

        for (String w: listWindows) {
            if(!w.equals(parentWindow)){
                String childWindow = w;
                driver.switchTo().window(childWindow);
            }

        }
    }
    public void switchToMainWindow(){
        String parentWindow = driver.getWindowHandle();
        Set<String> listWindows = driver.getWindowHandles();

        for (String w: listWindows) {
            if(!w.equals(parentWindow)){
                String childWindow = w;
                driver.close();
                driver.switchTo().window(childWindow);
            }

        }
    }

    public String getNewWindowText(){
        return newWindowHeader.getText();
    }
    public String getMainWindowText(){
        return header.getText();
    }
}
