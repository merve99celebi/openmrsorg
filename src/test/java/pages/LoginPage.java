package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class LoginPage extends ReusableMethods{

    public LoginPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath= "//label[@for='username']")
    public WebElement verifyLoginPage;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(css = "button[class^='-esm-login']")
    private WebElement continueBtn;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = "button[class^='-esm-login']")
    private WebElement loginBtn;
}
