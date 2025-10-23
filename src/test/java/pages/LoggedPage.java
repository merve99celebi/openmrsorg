package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

import java.util.List;

public class LoggedPage extends ReusableMethods {
    public LoggedPage(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//div[1]/div[1]/div/p[1]")
    public WebElement verifyClinicText;

    @FindBy(xpath = "//button[@data-testid='searchPatientIcon']")
    public WebElement searchBtn;

    @FindBy(xpath = "//input[@data-testid='patientSearchBar']")
    public WebElement searchBarInput;

    @FindBy(xpath = "//div[@data-testid='floatingSearchResultsContainer']/div/div/p")
    public WebElement totalResultsText;

    @FindBy(xpath = "//a/div[2]/div[1]/div/span")
    public List<WebElement> searchResultsRow;
}
