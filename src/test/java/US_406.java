import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class US_406 extends BaseDriver {

    HomePage homePage;
    LoginPage loginPage;
    DemoPage demoPage;
    LoggedPage loggedPage;
    PatientInfoPage patientPage;

    @Test
    public void searchPatient() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        demoPage = new DemoPage();
        loggedPage = new LoggedPage();
        patientPage= new PatientInfoPage();

        driver.get("https://openmrs.org/");
        homePage.myClick(homePage.homePageText);
        ReusableMethods.threadWait(2);

        homePage.myClick(homePage.demoBtn);
        ReusableMethods.threadWait(2);

        wait.until(ExpectedConditions.elementToBeClickable(demoPage.openMrs3Btn));
        ReusableMethods.threadWait(2);

        homePage.scrollToElement(demoPage.openMrs3Btn);
        ReusableMethods.threadWait(2);
        homePage.myClick(demoPage.openMrs3Btn);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.verifyLoginPage));

        loginPage.mySendKeys(loginPage.userNameInput, "admin");
        loginPage.myClick(loginPage.continueLoginBtn);
        loginPage.mySendKeys(loginPage.passwordInput, "Admin123");
        ReusableMethods.threadWait(2);
        loginPage.myClick(loginPage.continueLoginBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedPage.verifyClinicText));
        loggedPage.verifyDisplayed(loggedPage.verifyClinicText, "Clinic");

        wait.until(ExpectedConditions.elementToBeClickable(loggedPage.searchBtn));
        loggedPage.myClick(loggedPage.searchBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedPage.searchBarInput));
        String patientFullname = "David";
        loggedPage.mySendKeys(loggedPage.searchBarInput, patientFullname);

        wait.until(ExpectedConditions.visibilityOfAllElements(loggedPage.searchResultsRow));
        loggedPage.myClick(loggedPage.searchResultsRow.get(
                (int)(Math.random() * loggedPage.searchResultsRow.size())));

        wait.until(ExpectedConditions.visibilityOf(patientPage.patientSummaryBtn));
        patientPage.verifyContainsText(patientPage.patientSummaryBtn, "Patient summary");

        patientPage.myClick(patientPage.actionsBtn);
    }
}
