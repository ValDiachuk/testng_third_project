package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Driver;
import java.util.List;
public class CarvanaSearchCarPage {
    public CarvanaSearchCarPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "button[class*='DropDownMenustyles']")
    public List<WebElement> filterOptions;
    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInputBox;
    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "div[data-qa='result-tile']")
    public List<WebElement> resultTile;

    @FindBy(css = "picture[data-qa='base-vehicle-image']")
    public List<WebElement> vehicleImage;

    @FindBy(css = "svg[data-qa='favorite-icon']")
    public List<WebElement> favoriteButton;

    @FindBy(css = "div[data-qa='inventory-type-experiment']")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModel;

    @FindBy(css = "div[data-qa='trim-mileage']")
    public List<WebElement> trimMileage;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> price;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public List<WebElement> monthlyPayment;

    @FindBy(css = ".down-payment")
    public List <WebElement> downPayment;

    @FindBy(css = "div[data-qa='shipping-cost']")
    public List<WebElement> delivery;

}
