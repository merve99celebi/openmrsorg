import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseDriver;

public class US_402and403 extends BaseDriver {

    private HomePage homePage;
    private LoginPage loginPage;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test(priority = 1, description = "Verify that home page is visible")
    public void verifyHomePage() {
        homePage.verifyDisplayed(homePage.homePageText, "OpenMRS");
    }
    @Test(priority = 2, description = "Click on 'demo' button")
    public void clickDemoBtn() {
        homePage.myClick(homePage.demoBtn);
    }
    @Test(priority = 3, description = "Click on 'Explore OpenMRS2' button")
    public void clickExploreOpenMRS2Btn() {
        homePage.myClick(homePage.exploreOpenMRS2Btn);
    }
    @Test(priority = 4, description = "Click on 'Enter the OpenMRS2 demo' button")
    public void clickEnterOpenMRS2Btn() {
        homePage.myClick(homePage.openMrs2Btn);
    }
    @Test(priority = 5, description = "Enter your username in the Username Text Box")
    public void enterValidUsername() {
        loginPage.mySendKeys(loginPage.userNameInput, username);
    }
    @Test(priority = 6, description = "Enter your password in the Password Text Box")
    public void enterValidPassword() {
        loginPage.mySendKeys(loginPage.passwordInput, password);
    }
    @Test(priority = 7, description = "Click on 'Inpatient Ward' button")
    public void clickInpatientWardBtn() {
        loginPage.myClick(loginPage.verifyInpatientWard);
    }
    @Test(priority = 8, description = "Click 'Login' button")
    public void clickLoginBtn() {
        loginPage.myClick(loginPage.loginBtn);
    }
    @Test(priority = 9, description = "Verify that 'Logged In home page' is visible")
    public void verifyLoggedInHomePage() {
homePage.verifyDisplayed(homePage.LoggedInHomePageText, "Logged in as Super User (admin) at Inpatient Ward.");
    }
    @Test(priority = 10, description = "Click 'Logout' button")
    public void clickLogOutBtn() {
        homePage.myClick(homePage.LogOutBtn);
    }
    @Test(priority = 11, description = "Verify that 'Login' text is visible")
    public void verifyLoggedOut(){
        loginPage.verifyDisplayed(loginPage.verifyLoginPage,"LOGIN");
    }

}
