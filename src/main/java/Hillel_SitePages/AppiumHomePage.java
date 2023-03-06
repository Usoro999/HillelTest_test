package Hillel_SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppiumHomePage {
    WebDriver driver;

    public AppiumHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btn-consultation-hero")
    WebElement consultationButton;
    @FindBy(xpath = "//a[@href = 'https://ithillel.ua/courses/programming']//p[@class = 'course-cat-bar_descr']")
    WebElement programmingTextBox;
    @FindBy(xpath = "//p[@class = 'proftest-link_descr']")
    WebElement questionWhatCourseToChose;
    @FindBy(xpath = "//span[@class = 'advantages-list_title']")
    List<WebElement> listOfAdvantages;
    @FindBy(xpath = "//section[@class = 'section -advantages']//p[@class = 'p-xl']")
    WebElement advantages;
    @FindBy(xpath = "//p[@class = 'course-cat-bar_label']")
    List<WebElement> listOfCourses;


    public void printTextFromConsultButton(){
        System.out.println(consultationButton.getText());
    }



    public void scrollToTextProgrammingBox(){
        Actions actions = new Actions(driver);
        actions.moveToElement(programmingTextBox).build().perform();
    }

    public void printTextFromProgramuvanniaBox() {
        System.out.println(programmingTextBox.getText());
    }
    public void scrollToQuestionBox(){
        Actions actions = new Actions(driver);
        actions.moveToElement(questionWhatCourseToChose).build().perform();
    }

    public void printTextFromDescription() {
        System.out.println(questionWhatCourseToChose.getText());
    }

    public void printListOfAdvantages(){
        for (WebElement el: listOfAdvantages){
            System.out.println(el.getText());
        }
    }
    public void scrollToAdvantagesList(){
        Actions actions = new Actions(driver);
        actions.moveToElement(advantages).build().perform();
    }

    public void printAllCourses() {
        for (WebElement el:listOfCourses){
            System.out.println(el.getText());
        }
    }
}
