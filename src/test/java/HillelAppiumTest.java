import AppiumConfig.AppiumBaseClass;
import Hillel_SitePages.HomePageForAppium;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HillelAppiumTest extends AppiumBaseClass {

    HomePageForAppium homePageForAppium;
    @BeforeMethod
    public void hillelHomePageStart(){
        driver.get("https://ithillel.ua");
    }

    @Test
    public void checkFiveElementsOnPage(){
        homePageForAppium = new HomePageForAppium(driver);

        homePageForAppium.printTextFromConsultButton(); // print text button
        homePageForAppium.scrollToTextProgrammingBox();
        homePageForAppium.printAllCourses();            // print all courses from Hillel
        homePageForAppium.printTextFromProgramuvanniaBox(); // print description of Programming course
        homePageForAppium.scrollToQuestionBox();
        homePageForAppium.printTextFromDescription();    // print text from question description
        homePageForAppium.scrollToAdvantagesList();
        homePageForAppium.printListOfAdvantages();       // print list of advantages


    }
}
