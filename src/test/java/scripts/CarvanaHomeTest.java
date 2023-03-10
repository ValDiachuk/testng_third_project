package scripts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;
import util.TestData;
import util.Waiter;

public class CarvanaHomeTest extends CarvanaHome {

    @BeforeMethod
    public void setPage(){

        carvanaHomePage = new CarvanaHomePage();
    }
    /*
Test Case 1: Test name = Validate Carvana home page title and url
Test priority = 1
Given user is on "https://www.carvana.com/"
Then validate title equals  "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
And validate url equals  "https://www.carvana.com/
     */

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndURL(){
        Assert.assertEquals(driver.getTitle(), TestData.title);
        Assert.assertEquals(driver.getCurrentUrl(), TestData.url);
    }
/*
Test Case 2: Test name = Validate the Carvana logo
Test priority = 2
Given user is on "https://www.carvana.com/"
Then validate the logo of the “Carvana” is displayed
 */
    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateLogo(){
        Assert.assertTrue(carvanaHomePage.logo.isDisplayed());
    }
    /*
Test Case 3: Test name = Validate the main navigation section items
Test priority = 3
Given user is on "https://www.carvana.com/"
Then validate the navigation section items below are displayed
|HOW IT WORKS      |
|ABOUT CARVANA     |
|SUPPORT & CONTACT |
     */
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainSelectionItems(){

        for (int i = 0; i < carvanaHomePage.navigationItems.size(); i++) {
            Assert.assertTrue(carvanaHomePage.navigationItems.get(i).isDisplayed());
        }
    }
    /*
Test Case 4: Test name = Validate the sign in error message
Test priority = 4
Given user is on "https://www.carvana.com/"
When user clicks on “SIGN IN” button
Then user should be navigated to “Sign in” modal
When user enters email as johndoe   @gmail.com
And user clicks on "CONTINUE" button
And user enters password as "abcd1234"
And user clicks on "SIGN IN" button
Then user should see error message as "Email address and/or password combination is incorrect."
     */
    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignInErrorMessage(){

        carvanaHomePage.signInButton.click();
        Waiter.waitForVisibilityOfElement(carvanaHomePage.signInButton,3);
        //Assert.assertTrue(carvanaHomePage.modal.isDisplayed());
        carvanaHomePage.emailInput.sendKeys("johndoe@gmail.com");
        carvanaHomePage.continueButton.click();
        carvanaHomePage.passwordInput.sendKeys("abcd1234");
        carvanaHomePage.signInButtonModal.click();
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect.");
    }
}
