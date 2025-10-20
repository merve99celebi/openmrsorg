package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class LoginPage extends ReusableMethods {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//form[@id='login-form']/fieldset/legend")
    public WebElement verifyLoginPage;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "Outpatient Clinic")
    public WebElement outpatientBtn;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;
}
