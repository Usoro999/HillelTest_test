package Hillel_SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
