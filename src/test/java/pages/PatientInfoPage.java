package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

import java.util.List;

public class PatientInfoPage extends ReusableMethods {
    public PatientInfoPage(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//div[1]/div/a/span/span")
    public WebElement patientSummaryBtn;

    @FindBy(xpath = "//button[@aria-controls='custom-actions-overflow-menu']/span")
    public WebElement actionsBtn;

    @FindBy(xpath = "//div[@data-extension-id='mark-patient-deceased-button']")
    public WebElement deceasedBtn;

    @FindBy(xpath = "//header[@aria-label='Workspace header']/a")
    public WebElement markPatientDeceasedText;

    @FindBy(xpath = "//label/span[1]")
    public List<WebElement> casueOfDeathBtns;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveCloseBtn;

    @FindBy(xpath = "//span[@title='Deceased']")
    public WebElement deceasedText;
}
