package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class LoginPage extends ReusableMethods {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath= "//div[@class='cds--tile -esm-login__login__loginCard___iiPcZ'")
    public WebElement verifyLoginPage;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "Outpatient Clinic")
    public WebElement outpatientBtn;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    @FindBy(xpath = "//li[@id='Inpatient Ward']")
    public WebElement verifyInpatientWard;

    @FindBy(xpath = "//li[@id='Outpatient Clinic']")
    public WebElement verifyOutpatientClinic;

    @FindBy(xpath = "//li[@id='//li[@id='Isolation Ward']']")
    public WebElement verifyIsolationWard;

    @FindBy(xpath = "//li[@id='Pharmacy']")
    public WebElement verifyPharmacy;

    @FindBy(xpath = "//li[@id='Laboratory']")
    public WebElement verifyLaboratory;

    @FindBy(xpath = "//li[@id='Registration Desk']")
    public WebElement verifyRegistrationDesk;

    @FindBy(xpath = "//div[@id='error-message']")
    public WebElement verifyInvalidMessage;


}

