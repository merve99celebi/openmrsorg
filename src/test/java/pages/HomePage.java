package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class HomePage extends ReusableMethods {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//div/h1/span")
    public WebElement homePageText;

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement demoBtn;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMRS2Btn;



    @FindBy(xpath = "//div[@class='row']/div/h4")
    public WebElement LoggedInHomePageText;

    @FindBy(xpath = "//li[@class='nav-item logout']/a")
    public WebElement LogOutBtn;
}
