import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoggedPage;
import pages.LoginPage;
import utilities.BaseDriver;
import utilities.ConfigReader;

public class US_408 extends BaseDriver {
    String patientFullname = "Ibrahim Huseynli";

    @Test
    public void patientListing() {
        driver.get(ConfigReader.getProperty("url"));

        HomePage homeP = new HomePage();
        DemoPage demoP = new DemoPage();
        LoginPage loginP = new LoginPage();
        LoggedPage loggedP = new LoggedPage();

        homeP.verifyContainsText(homeP.homePageText, "OpenMRS");
        homeP.myClick(homeP.demoBtn);

        demoP.verifyContainsText(demoP.demoPageText, "Demo");
        demoP.jsClick(demoP.openMrs3Btn);

        loginP.verifyContainsText(loginP.verifyLoginPage, "Username");
        loginP.mySendKeys(loginP.userNameInput, ConfigReader.getProperty("usernameValid"));
        loginP.myClick(loginP.continueLoginBtn);
        loginP.mySendKeys(loginP.passwordInput, ConfigReader.getProperty("passwordValid"));
        loginP.myClick(loginP.continueLoginBtn);

        loggedP.verifyContainsText(loggedP.verifyClinicText,"Clinic");

        loggedP.myClick(loggedP.searchBtn);
        loggedP.mySendKeys(loggedP.searchBarInput, patientFullname);

        wait.until(ExpectedConditions.visibilityOf(loggedP.totalResultsText));
        wait.until(ExpectedConditions.visibilityOfAllElements(loggedP.searchResultsRow));
        int totalResultsToINT =
                Integer.parseInt(loggedP.totalResultsText.getText().replaceAll("[^0-9]",""));
        int searchResultsToINT = loggedP.searchResultsRow.size();

        Assert.assertEquals(totalResultsToINT,searchResultsToINT,"Result numbers don't match!");
    }
}
