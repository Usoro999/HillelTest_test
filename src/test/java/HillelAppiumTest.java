import AppiumConfig.AppiumBaseClass;
import Hillel_SitePages.AppiumHomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HillelAppiumTest extends AppiumBaseClass {

    AppiumHomePage appiumHomePage;
    @BeforeMethod
    public void hillelHomePageStart(){
        driver.get("https://ithillel.ua");
    }

    @Test
    public void checkFiveElementsOnPage(){
        appiumHomePage = new AppiumHomePage(driver);

        appiumHomePage.printTextFromConsultButton(); // print text button
        appiumHomePage.scrollToTextProgrammingBox();
        appiumHomePage.printAllCourses();            // print all courses from Hillel
        appiumHomePage.printTextFromProgramuvanniaBox(); // print description of Programming course
        appiumHomePage.scrollToQuestionBox();
        appiumHomePage.printTextFromDescription();    // print text from question description
        appiumHomePage.scrollToAdvantagesList();
        appiumHomePage.printListOfAdvantages();       // print list of advantages


    }
}
