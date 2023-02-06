package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarPage;
import util.ConfigReader;
import util.Driver;

public class CarvanaHome {
    WebDriver driver;
    SoftAssert softAssert;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchCarPage carvanaSearchCarPage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        softAssert = new SoftAssert();
        carvanaHomePage = new CarvanaHomePage();
    }

    @AfterMethod
    public void teardown() {
        softAssert.assertAll();
        Driver.quitDriver();
}
}
