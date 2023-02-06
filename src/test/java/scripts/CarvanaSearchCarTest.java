package scripts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarPage;
import util.Waiter;

public class CarvanaSearchCarTest extends CarvanaHome{
    @BeforeMethod
    public void setPage(){
        carvanaHomePage = new CarvanaHomePage();
        carvanaSearchCarPage = new CarvanaSearchCarPage();
        carvanaHomePage.searchCarsButton.click();
        Waiter.waitForVisibilityOfElement(carvanaHomePage.searchCarsButton,4);
    }
    /*
Test Case 5: Test name = Validate the search filter options and search button
Test priority = 5
Given user is on "https://www.carvana.com/"
When user clicks on "SEARCH CARS" link
Then user should be routed to "https://www.carvana.com/cars"
And user should see filter options
|PAYMENT & PRICE      |
|MAKE & MODEL      |
|BODY TYPE |
|YEAR & MILEAGE      |
|FEATURES      |
|MORE FILTERS |
    */
    @Test(priority = 1, description = "Validate the search filter options and search button")
    public void validateSearchFilterOptionsAndSearchButton(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        for (int i = 0; i < carvanaSearchCarPage.filterOptions.size(); i++) {
            Assert.assertTrue(carvanaSearchCarPage.filterOptions.get(i).isDisplayed());
        }
    }
    /*
Test Case 6: Test name = Validate the search result tiles
Test priority = 6
Given user is on "https://www.carvana.com/"
When user clicks on "SEARCH CARS" link
Then user should be routed to "https://www.carvana.com/cars"
When user enters "mercedes-benz" to the search input box
And user clicks on "GO" button in the search input box
Then user should see "mercedes-benz" in the url
And validate each result tile

VALIDATION OF EACH TILE INCLUDES BELOW
Make sure each result tile is displayed with below information
1. an image
2. add to favorite button
3. tile body
ALSO VALIDATE EACH TILE BODY:
Make sure each tile body has below information
1. Inventory type - text should be displayed and should not be null or empty
2. Year-Make-Model information - text should be displayed and should not be null or empty
3. Trim-Mileage information - text should be displayed and should not be null or empty
4. Price - Make sure that each price is more than zero
5. Monthly Payment information - text should be displayed and should not be null or empty
6. Down Payment information - text should be displayed and should not be null or empty
    */
    @Test(priority = 2, description = "Validate the search result tiles")
    public void validateSearchResultTiles(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaSearchCarPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaSearchCarPage.goButton.click();
        Waiter.pause(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        String carPrice;

        for (int i = 0; i < carvanaSearchCarPage.resultTile.size(); i++) {
            Assert.assertTrue(carvanaSearchCarPage.vehicleImage.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarPage.favoriteButton.get(i).isDisplayed());

            Assert.assertTrue(carvanaSearchCarPage.inventoryType.get(i).isDisplayed()
                    && (carvanaSearchCarPage.inventoryType.get(i) != null || !carvanaSearchCarPage.inventoryType.get(i).getText().isEmpty()));

            Assert.assertTrue(carvanaSearchCarPage.yearMakeModel.get(i).isDisplayed()
            && (carvanaSearchCarPage.yearMakeModel.get(i) != null || !carvanaSearchCarPage.yearMakeModel.get(i).getText().isEmpty()));

            Assert.assertTrue(carvanaSearchCarPage.trimMileage.get(i).isDisplayed()
                    && (carvanaSearchCarPage.trimMileage.get(i) != null || !carvanaSearchCarPage.trimMileage.get(i).getText().isEmpty()));

            carPrice = carvanaSearchCarPage.price.get(i).getText();
            carPrice = carPrice.replaceAll("[^0-9]", "");
            Assert.assertTrue(Integer.parseInt(carPrice) > 0);

            Assert.assertTrue(carvanaSearchCarPage.monthlyPayment.get(i).isDisplayed()
                    && (carvanaSearchCarPage.monthlyPayment.get(i) != null || !carvanaSearchCarPage.monthlyPayment.get(i).getText().isEmpty()));

            Assert.assertTrue(carvanaSearchCarPage.downPayment.get(i).isDisplayed()
                    && (carvanaSearchCarPage.downPayment.get(i) != null || !carvanaSearchCarPage.downPayment.get(i).getText().isEmpty()));

            Assert.assertTrue(carvanaSearchCarPage.delivery.get(i).isDisplayed()
                    && (carvanaSearchCarPage.delivery.get(i) != null || !carvanaSearchCarPage.delivery.get(i).getText().isEmpty()));

        }
    }
}
