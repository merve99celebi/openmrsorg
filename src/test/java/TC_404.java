import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterAPatient;
import utilities.BaseDriver;
import utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_404 extends BaseDriver {

    @Test
    public void patientRegistration(){
        HomePage hp = new HomePage();
        LoginPage lp = new LoginPage();
        DemoPage dp = new DemoPage();
        RegisterAPatient rgp = new RegisterAPatient();


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
        ReusableMethods.threadWait(2);
        rgp.myClick(rgp.addPatientBtn);
        rgp.mySendKeys(rgp.firstName, "marc");
        rgp.mySendKeys(rgp.familyName, "marces");
        rgp.myClick(rgp.gender);
        ReusableMethods.threadWait(2);
        rgp.myClick(rgp.dateofBirthNoBtn);
        rgp.mySendKeys(rgp.estimatedAgeBtn, "4");
        rgp.mySendKeys(rgp.adress1,"home1");
        rgp.mySendKeys(rgp.adress2,"home2");
        rgp.mySendKeys(rgp.city,"africa");
        rgp.mySendKeys(rgp.state,"province");
        rgp.mySendKeys(rgp.country,"gine");
        rgp.mySendKeys(rgp.postalCode,"00322");
        rgp.mySendKeys(rgp.phoneNumber,"234723946");
        rgp.myClick(rgp.registerPatientBtn);

        Assert.assertTrue(driver.findElement(By.xpath("//button[@aria-label='Add patient']")).isDisplayed());
    }
}
