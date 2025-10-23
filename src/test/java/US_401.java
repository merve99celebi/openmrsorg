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

    private String invalidUsername = "ss";
    private String invalidPassword = "ss";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        demoPage = new DemoPage(driver);
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
    @Test(priority = 4, description = "Click on 'Enter the OpenMRS2 demo' button")
    public void clickEnterOpenMRS3Btn() {
       // wait.until(ExpectedConditions.elementToBeClickable(demoPage.enterOpenMrs3));
        demoPage.myClick(demoPage.enterOpenMrs3);
    }
    @Test(priority = 5, description = "Verify that Login page is visible")
    public void verifyLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.verifyLoginPage));
        loginPage.verifyDisplayed(loginPage.verifyLoginPage, "LOGIN");
    }
    @Test(priority = 6, description = "Enter invalid username in the Username Text box")
    public void enterInvalidUsername() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.userNameInput));
        loginPage.mySendKeys(loginPage.userNameInput, invalidUsername);
    }
    @Test(priority = 7, description = "Click on continue button")
    public void clickContinueBtn() {
        //wait.until(ExpectedConditions.elementToBeClickable(loginPage.continueLoginBtn));
        loginPage.myClick(loginPage.continueLoginBtn);
    }
    @Test(priority = 8, description = "Enter invalid username in the Username Text box")
    public void enterInvalidPassword() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput));
        loginPage.mySendKeys(loginPage.passwordInput, invalidPassword);
    }
    @Test(priority = 9, description = "Click 'Login' button")
    public void clickLoginBtn() {
        //wait.until(ExpectedConditions.elementToBeClickable(loginPage.continueLoginBtn));
        loginPage.myClick(loginPage.continueLoginBtn);
    }
    @Test(priority = 10, description = "Verify error message is visible")
    public void verifyErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        loginPage.verifyDisplayed(loginPage.errorMessage, "Error");
    }
}
