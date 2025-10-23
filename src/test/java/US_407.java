import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseDriver;
import utilities.ConfigReader;

public class US_407 extends BaseDriver {
    private HomePage homeP;
    private DemoPage demoP;
    private LoginPage loginP;
    private LoggedPage loggedP;
    private PatientInfoPage patientP;

    @BeforeClass
    public void setupPages() {
        driver.get(ConfigReader.getProperty("url"));

        homeP = new HomePage();
        demoP = new DemoPage();
        loginP = new LoginPage();
        loggedP = new LoggedPage();
        patientP = new PatientInfoPage();
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
        loggedP.verifyDisplayed(loggedP.verifyClinicText, "Clinic");

        wait.until(ExpectedConditions.elementToBeClickable(loggedP.searchBtn));
        loggedP.myClick(loggedP.searchBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedP.searchBarInput));
        String patientFullname = "Ibrahim Huseynli";
        loggedP.mySendKeys(loggedP.searchBarInput, patientFullname);

        wait.until(ExpectedConditions.visibilityOfAllElements(loggedP.searchResultsRow));
        loggedP.myClick(loggedP.searchResultsRow.get(
                (int)(Math.random() * loggedP.searchResultsRow.size())));

        wait.until(ExpectedConditions.visibilityOf(patientP.patientSummaryBtn));
        patientP.verifyContainsText(patientP.patientSummaryBtn, "Patient summary");

        patientP.myClick(patientP.actionsBtn);
        patientP.myClick(patientP.deceasedBtn);

        wait.until(ExpectedConditions.visibilityOf(patientP.markPatientDeceasedText));
        patientP.verifyDisplayed(patientP.markPatientDeceasedText, "Mark patient deceased");

        wait.until(ExpectedConditions.visibilityOfAllElements(patientP.casueOfDeathBtns));
        patientP.myClick(patientP.casueOfDeathBtns.get(1));
        patientP.myClick(patientP.saveCloseBtn);

        patientP.verifyContainsText(patientP.deceasedText, "Deceased");
    }
}
