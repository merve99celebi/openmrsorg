import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoggedPage;
import pages.LoginPage;
import utilities.BaseDriver;

public class US_402and403 extends BaseDriver {

    private HomePage homePage;
    private LoginPage loginPage;
    private DemoPage demoPage;
    private LoggedPage loggedPage;
    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        demoPage = new DemoPage(driver);
        loggedPage = new LoggedPage(driver);
    }
    @Test(priority = 1, description = "Verify that home page is visible")
    public void verifyHomePage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.homePageText));
        homePage.verifyDisplayed(homePage.homePageText, "OpenMRS");
    }
    @Test(priority = 2, description = "Click on 'demo' button")
    public void clickDemoBtn() {
        //wait.until(ExpectedConditions.elementToBeClickable(homePage.demoBtn));
        homePage.myClick(homePage.demoBtn);
    }
    @Test(priority = 3, description = "Click on 'Explore OpenMRS3' button")
    public void clickExploreOpenMRS3Btn() {
        //wait.until(ExpectedConditions.elementToBeClickable(demoPage.openMrs3Btn));
        demoPage.myClick(demoPage.openMrs3Btn);
    }
    @Test(priority = 4, description = "Click on 'Enter the OpenMRS3 demo' button")
    public void clickEnterOpenMRS3Btn() {
       // wait.until(ExpectedConditions.elementToBeClickable(demoPage.enterOpenMrs3));
        demoPage.myClick(demoPage.enterOpenMrs3);
    }
    @Test(priority = 5, description = "Enter your username in the Username Text Box")
    public void enterValidUsername() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.userNameInput));
        loginPage.mySendKeys(loginPage.userNameInput, username);
    }
    @Test(priority = 6, description = "Click on continue button")
    public void clickContinueBtn() {
        //wait.until(ExpectedConditions.elementToBeClickable(loginPage.continueLoginBtn));
        loginPage.myClick(loginPage.continueLoginBtn);
    }
    @Test(priority = 7, description = "Enter your password in the Password Text Box")
    public void enterValidPassword() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput));
        loginPage.mySendKeys(loginPage.passwordInput, password);
    }
    @Test(priority = 8, description = "Click 'Login' button")
    public void clickLoginBtn() {
        //wait.until(ExpectedConditions.elementToBeClickable(loginPage.continueLoginBtn));
        loginPage.myClick(loginPage.continueLoginBtn);
    }
    @Test(priority = 9, description = "Verify logged in")
    public void verifyLoggedInHomePage() {
        wait.until(ExpectedConditions.visibilityOf(loggedPage.verifyClinicText));
        loggedPage.verifyDisplayed(loggedPage.verifyClinicText, "Clinic");
    }
    @Test(priority = 10, description = "Click 'My Account' button")
    public void clickMyAccountBtn() {
        //wait.until(ExpectedConditions.elementToBeClickable(loggedPage.MyAccountBtn));
        loggedPage.myClick(loggedPage.MyAccountBtn);
    }
    @Test(priority = 11, description = "Click 'logout' button")
    public void clickLogout() {
       // wait.until(ExpectedConditions.elementToBeClickable(loggedPage.logoutBtn));
        loggedPage.myClick(loggedPage.logoutBtn);
    }
    @Test(priority = 12, description = "Verify logged out")
    public void verifyLoggedOut() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.verifyLoginPage));
        loginPage.verifyDisplayed(loginPage.verifyLoginPage, "LOGIN");
    }

}
