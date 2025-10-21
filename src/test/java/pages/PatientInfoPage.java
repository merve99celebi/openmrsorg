package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class PatientInfoPage extends ReusableMethods {
    public PatientInfoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='float-left']/li[7]/a/div")
    public WebElement deleteBtn;

    @FindBy(id = "delete-reason")
    public WebElement reasonInput;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']/div[2]/button[1]")
    public WebElement confirmBtn;
}
