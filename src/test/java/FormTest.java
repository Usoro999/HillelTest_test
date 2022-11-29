import Config.BaseTest;
import PageObjects.MainPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FormTest extends BaseTest {
    static final String siteURL = "https://demoqa.com/automation-practice-form";
    MainPage mainPage = new MainPage(driver);

    @Before
    public void before(){
        if(!driver.getCurrentUrl().equals(siteURL)) {
            driver.get("https://demoqa.com/automation-practice-form");
            System.out.println(driver.getTitle());
        }
    }
    @Test
    public void checkFillForm(){

        mainPage.fillForm("Yurii",
                "Soroka",
                "email@email.com",
                "+380970000000",
                "math");

    }

}

