import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class US_405 extends BaseDriver {

    @Test
    public void myAccountChange() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        DemoPage demoPage = new DemoPage();

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
        loginPage.myClick(loginPage.loginbtn);
        homePage.myClick(homePage.MyAccountBtn);
        ReusableMethods.threadWait(2);
        homePage.myClick(homePage.changeLanguageBtn);
        homePage.myClick(homePage.cancelBtn);
        homePage.myClick(homePage.MyAccountBtn);
        homePage.myClick(homePage.changePasswordBtn);
        homePage.myClick(homePage.cancelBtn);
    }
}
