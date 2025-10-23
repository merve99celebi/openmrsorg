import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class US_406_Negative extends BaseDriver {
    HomePage homePage;
    LoginPage loginPage;
    DemoPage demoPage;
    LoggedPage loggedPage;
    PatientInfoPage patientP;

    @Test
    public void searchPatientNegative(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        demoPage = new DemoPage();
        loggedPage = new LoggedPage();
        patientP= new PatientInfoPage();

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
        ReusableMethods.threadWait(3);
        loginPage.myClick(loginPage.continueLoginBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedPage.verifyClinicText));
        loggedPage.verifyDisplayed(loggedPage.verifyClinicText, "Clinic");

        wait.until(ExpectedConditions.elementToBeClickable(loggedPage.searchBtn));
        loggedPage.myClick(loggedPage.searchBtn);

        wait.until(ExpectedConditions.visibilityOf(loggedPage.searchBarInput));
        String patientFullname = "Artyhjnbv";
        loggedPage.mySendKeys(loggedPage.searchBarInput, patientFullname);

        loggedPage.verifyContainsText(loggedPage.noPatientMessage, "Sorry, no patient charts were found");
    }
}