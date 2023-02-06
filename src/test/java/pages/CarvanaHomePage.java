package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import util.Driver;
import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[data-qa='logo-wrapper'] svg")
    public WebElement logo;

    @FindBy(css = "div[data-qa='navigation-wrapper'] svg")
    public List<WebElement> navigationItems;

    @FindBy(css = "div[data-qa='desktop-wrapper']")
    public WebElement signInButton;

    @FindBy(css = "div[class='my7ns9e']")
    public WebElement modal;

    @FindBy(css = "input[data-qa='sign-in-email']")
    public WebElement emailInput;

    @FindBy(css = "button[data-qa='enter-email-submit']")
    public WebElement continueButton;

    @FindBy(css = "input[data-qa='sign-in-password']")
    public WebElement passwordInput;

    @FindBy(css = "button[data-qa='sign-in-submit']")
    public WebElement signInButtonModal;

    @FindBy(css = "#error-banner p")
    public WebElement errorMessage;

    @FindBy(css = "a[data-cv-test ='headerSearchLink']")
    public WebElement searchCarsButton;
}

