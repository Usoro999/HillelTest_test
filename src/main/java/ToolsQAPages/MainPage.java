package ToolsQAPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id = 'firstName']")
    WebElement nameField;
    @FindBy(xpath = "//input[@id = 'lastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id = 'userEmail']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id = 'userNumber']")
    WebElement userPhoneField;
    @FindBy(xpath = "//input[@id ='subjectsInput']")
    WebElement subjectsField;


    public void  fillForm(String name, String lastName, String email, String userPhone, String subject){
        nameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        userPhoneField.sendKeys(userPhone);
        subjectsField.sendKeys(subject);
        subjectsField.sendKeys(Keys.ENTER);
    }
}