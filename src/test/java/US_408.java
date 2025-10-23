import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoggedPage;
import pages.LoginPage;
import utilities.BaseDriver;
import utilities.ConfigReader;

public class US_408 extends BaseDriver {
    private HomePage homeP;
    private DemoPage demoP;
    private LoginPage loginP;
    private LoggedPage loggedP;
    String patientFullname = "Ibrahim Huseynli";

    @BeforeClass
    public void setupPages() {
        driver.get(ConfigReader.getProperty("url"));

        homeP = new HomePage();
        demoP = new DemoPage();
        loginP = new LoginPage();
        loggedP = new LoggedPage();
    }

    @Test
    public void patientListing() {
        homeP.verifyDisplayed(homeP.homePageText, "OpenMRS");
        homeP.myClick(homeP.demoBtn);

        demoP.verifyContainsText(demoP.demoPageText, "Demo");
        demoP.jsClick(demoP.openMrs3Btn);

        wait.until(ExpectedConditions.visibilityOf(loginP.verifyLoginPage));
        loginP.verifyDisplayed(loginP.verifyLoginPage, "Username");
        loginP.mySendKeys(loginP.userNameInput, ConfigReader.getProperty("usernameValid"));
        loginP.myClick(loginP.continueLoginBtn);
        loginP.mySendKeys(loginP.passwordInput, ConfigReader.getProperty("passwordValid"));
        loginP.myClick(loginP.continueLoginBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedP.verifyClinicText));
        loggedP.verifyDisplayed(loggedP.verifyClinicText,"Clinic");

        wait.until(ExpectedConditions.elementToBeClickable(loggedP.searchBtn));
        loggedP.myClick(loggedP.searchBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedP.searchBarInput));
        loggedP.mySendKeys(loggedP.searchBarInput, patientFullname);

        wait.until(ExpectedConditions.visibilityOf(loggedP.totalResultsText));
        wait.until(ExpectedConditions.visibilityOfAllElements(loggedP.searchResultsRow));
        int totalResultsToINT =
                Integer.parseInt(loggedP.totalResultsText.getText().replaceAll("[^0-9]",""));
        int searchResultsToINT = loggedP.searchResultsRow.size();

        Assert.assertEquals(totalResultsToINT,searchResultsToINT,"Result numbers don't match!");
    }
}
