package Hillel_SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JavaPage {
    WebDriver driver;

    public JavaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class = 'course-rating_average']")
    WebElement courseRate;
    @FindBy(xpath = "//h1[@class = 'course-descriptor_header']")
    WebElement courseHeader;
    @FindBy(xpath = "//div[@class = 'introduction-info_content introduction-info-redactor']/p")
    WebElement courseDescription;
    @FindBys(@FindBy(xpath = "//div[@class = 'introduction-info-redactor_section']//li"))
    List<WebElement> goals;
    @FindBy(xpath = "//div[@class = 'introduction-info-redactor_section']")
    List<WebElement> g;

    public String getCourseRate() {
        return courseRate.getText();
    }

    public String getCourseTitle() {
        return courseHeader.getText();
    }

    public String getTitleOfPage() {
        return driver.getTitle();
    }


    public String getCourseDescription() {
        return courseDescription.getText();
    }
    public void getCourseGoals(){
        /*for (WebElement s:goals) {
            System.out.println(s.getText());
        }*/
        for(WebElement l: g){
            System.out.println(l.getText());
        }

    }
}
