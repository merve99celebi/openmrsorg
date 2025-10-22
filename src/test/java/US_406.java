import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class US_406 extends BaseDriver {

    @Test
    public void verifyLoggedPage(){
        HomePage hp= new HomePage();
        LoginPage lp= new LoginPage();
        driver.get("https://openmrs.org/");
        hp.myClick(hp.homePageText);
        hp.myClick(hp.demoBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='elementor-button-text'])[4]")));
        wait.until(ExpectedConditions.elementToBeClickable(hp.demoBtn));
        hp.myClick(hp.openMrs2Btn);
        wait.until(ExpectedConditions.elementToBeClickable(hp.openMrs2Btn));
        lp.verifyDisplayed(lp.verifyLoginPage, "Login");


    }

}
