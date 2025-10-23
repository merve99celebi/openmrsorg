import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseDriver;
import utilities.ConfigReader;

public class US_407 extends BaseDriver {
    String patientFullname = "john";

    @Test
    public void patientListing() {
        driver.get(ConfigReader.getProperty("url"));

        HomePage homeP = new HomePage();
        DemoPage demoP = new DemoPage();
        LoginPage loginP = new LoginPage();
        LoggedPage loggedP = new LoggedPage();
        PatientInfoPage patientP = new PatientInfoPage();

        homeP.verifyDisplayed(homeP.homePageText, "OpenMRS");
        homeP.myClick(homeP.demoBtn);

        demoP.verifyContainsText(demoP.demoPageText, "Demo");
        demoP.jsClick(demoP.openMrs3Btn);

        wait.until(ExpectedConditions.visibilityOf(loginP.verifyLoginPage));
        loginP.verifyContainsText(loginP.verifyLoginPage, "Username");
        loginP.mySendKeys(loginP.userNameInput, ConfigReader.getProperty("usernameValid"));
        loginP.myClick(loginP.continueLoginBtn);
        loginP.mySendKeys(loginP.passwordInput, ConfigReader.getProperty("passwordValid"));
        loginP.myClick(loginP.continueLoginBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedP.verifyClinicText));
        loggedP.verifyContainsText(loggedP.verifyClinicText, "Clinic");

        loggedP.myClick(loggedP.searchBtn);

        loggedP.mySendKeys(loggedP.searchBarInput, patientFullname);

        wait.until(ExpectedConditions.visibilityOfAllElements(loggedP.searchResultsRow));
        loggedP.myClick(loggedP.searchResultsRow.get(
                (int)(Math.random() * loggedP.searchResultsRow.size())));

        wait.until(ExpectedConditions.visibilityOf(patientP.patientSummaryBtn));
        patientP.verifyContainsText(patientP.patientSummaryBtn, "Patient summary");

        patientP.myClick(patientP.actionsBtn);
        patientP.myClick(patientP.deceasedBtn);

        wait.until(ExpectedConditions.visibilityOf(patientP.markPatientDeceasedText));
        patientP.verifyContainsText(patientP.markPatientDeceasedText, "Mark patient deceased");

        wait.until(ExpectedConditions.visibilityOfAllElements(patientP.casueOfDeathBtns));
        patientP.myClick(patientP.casueOfDeathBtns.get(1));
        patientP.myClick(patientP.saveCloseBtn);

        patientP.verifyContainsText(patientP.deceasedText, "Deceased");
    }
}
