package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class DemoPage extends ReusableMethods {

    public DemoPage(WebDriver driver){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//div[2]/nav/ul/li[2]/span")
    public WebElement demoPageText;

    @FindBy(xpath = "//span[@class='elementor-button-text']")
    public WebElement openMrs3Btn;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[3]")
    public WebElement enterOpenMrs3;
}