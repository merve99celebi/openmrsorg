package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

public class FindPatientPage extends ReusableMethods{
    public FindPatientPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "div input")
    public WebElement searchBarInput;

    @FindBy(css = "tr td:nth-child(1)")
    public WebElement searchBarResult;

    @FindBy(xpath = "//ul[@class='float-left']/li[7]/a/div")
    public WebElement deleteBtn;

    @FindBy(id = "delete-reason")
    public WebElement reasonInput;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']/div[2]/button[1]")
    public WebElement confirmBtn;

    @FindBy(css = "div h2")
    public WebElement findPatientText;
}
