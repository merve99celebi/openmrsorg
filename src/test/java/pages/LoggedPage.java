package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class LoggedPage extends ReusableMethods {
    public LoggedPage(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "Clinic")
    public WebElement verifyClinicText;
}
