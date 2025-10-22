import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterAPatient;
import utilities.BaseDriver;
import utilities.ReusableMethods;


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
        //lp.myClick(lp.);
        lp.mySendKeys(lp.passwordInput, "Admin123");
        ReusableMethods.threadWait(2);
        //lp.myClick(lp.);
        rgp.myClick(rgp.addPatientBtn);
        rgp.mySendKeys(rgp.firstName, "marc");
        rgp.mySendKeys(rgp.familyName, "marces");
        rgp.myClick(rgp.gender);
        rgp.myClick(rgp.birth);
        rgp.myClick(rgp.registerPatientBtn);





    }
}
