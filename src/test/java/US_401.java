import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseDriver;

public class US_401 extends BaseDriver {

    private HomePage homePage;
    private LoginPage loginPage;
private DemoPage demoPage;
    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test(priority = 1, description = "Verify that home page is visible")
    public void verifyHomePage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.homePageText));
        homePage.verifyDisplayed(homePage.homePageText, "OpenMRS");
    }
    @Test(priority = 2, description = "Click on 'demo' button")
    public void clickDemoBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.demoBtn));
        homePage.myClick(homePage.demoBtn);
    }
    @Test(priority = 3, description = "Click on 'Explore OpenMRS3' button")
    public void clickExploreOpenMRS3Btn() {
        wait.until(ExpectedConditions.elementToBeClickable(demoPage.exploreOpenMRS3Btn));
        demoPage.myClick(demoPage.exploreOpenMRS3Btn);
    }
    @Test(priority = 4, description = "Click on 'Enter the OpenMRS2 demo' button")
    public void clickEnterOpenMRS3Btn() {
        wait.until(ExpectedConditions.elementToBeClickable(demoPage.openMrs3Btn));
        demoPage.myClick(demoPage.openMrs3Btn);
    }
    @Test(priority = 5, description = "Verify that Login page is visible")
    public void verifyLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.verifyLoginPage));
        loginPage.verifyDisplayed(loginPage.verifyLoginPage, "LOGIN");
    }
    /*
    @Test(priority = 6, description = "Verify 'Inpatient Ward' is visible and clickable")
    public void verifyInpatientWardBtn() {
        loginPage.verifyDisplayed(loginPage.verifyInpatientWard, "Inpatient Ward");
    }
    @Test(priority = 7, description = "Verify 'Outpatient Clinic' is visible and clickable")
    public void verifyOutpatientClinicBtn() {
        loginPage.verifyDisplayed(loginPage.verifyOutpatientClinic, "Outpatient Clinic");
    }
    @Test(priority = 8, description = "Verify 'Isolation Ward' is visible and clickable")
    public void verifyIsolationWardBtn() {
        loginPage.verifyDisplayed(loginPage.verifyIsolationWard, "Isolation Ward");
    }
    @Test(priority = 9, description = "Verify 'Pharmacy' is visible and clickable")
    public void verifyPharmacyBtn() {
        loginPage.verifyDisplayed(loginPage.verifyPharmacy, "Pharmacy");
    }
    @Test(priority = 10, description = "Verify 'Laboratory' is visible and clickable")
    public void verifyLaboratoryBtn() {
        loginPage.verifyDisplayed(loginPage.verifyLaboratory, "Laboratory");
    }
    @Test(priority = 11, description = "Verify 'Registration Desk' is visible and clickable")
    public void verifyRegistrationDeskBtn() {
        loginPage.verifyDisplayed(loginPage.verifyRegistrationDesk, "Registration Desk");
    }
    @Test(priority = 12, description = "Click on 'Inpatient Ward' button")
    public void clickInpatientWardBtn() {
        loginPage.myClick(loginPage.verifyInpatientWard);
    }  */
    @Test(priority = 13, description = "Click 'Login' button")
    public void clickLoginBtn() {
        loginPage.myClick(loginPage.loginBtn);
    }
    @Test(priority = 14, description = "Verify error message is visible")
    public void verifyErrorMessage() {
        loginPage.verifyDisplayed(loginPage.verifyInvalidMessage, "Invalid username/password. Please try again.");
    }
}
