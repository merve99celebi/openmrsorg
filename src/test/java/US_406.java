import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class US_406 extends BaseDriver {

    @Test
    public void verifyLoggedPage(){
        HomePage hp= new HomePage();
        LoginPage lp= new LoginPage();
        DemoPage dp= new DemoPage();
        driver.get("https://openmrs.org/");
        hp.myClick(hp.homePageText);
        ReusableMethods.threadWait(2);
        hp.myClick(hp.demoBtn);
        ReusableMethods.threadWait(2);
        wait.until(ExpectedConditions.elementToBeClickable(dp.openMrs3Btn));
        ReusableMethods.threadWait(2);
        hp.scrollToElement(dp.openMrs3Btn);
        ReusableMethods.threadWait(2);
        hp.myClick(dp.openMrs3Btn);
        wait.until(ExpectedConditions.elementToBeClickable(lp.verifyLoginPage));
        lp.mySendKeys(lp.userNameInput, "admin");
        lp.myClick(lp.continueLoginBtn);
        lp.mySendKeys(lp.passwordInput, "Admin123");
        ReusableMethods.threadWait(2);
        lp.myClick(lp.continueLoginBtn);
    }

}
