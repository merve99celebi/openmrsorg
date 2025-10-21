import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseDriver;

public class US_406 extends BaseDriver {
    HomePage hp= new HomePage();
    LoginPage lp= new LoginPage();

    @Test
    public void verifyLoggedPage(){
        driver.get("https://openmrs.org/");
        hp.myClick(hp.homePageText);
        hp.myClick(hp.demoBtn);
        hp.myClick(hp.openMrs2Btn);
        lp.verifyDisplayed(lp.verifyLoginPage, "Login");

    }

}
