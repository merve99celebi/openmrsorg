package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.ReusableMethods;

import java.util.List;

public class AddPatientToQueue extends ReusableMethods {
    public AddPatientToQueue() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Search Patient Button']")
    public WebElement addPatientToQueueBtn;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@aria-label='Start visit']")
    public WebElement startVisitBtn;

    @FindBy(xpath = "//div/fieldset/div")
    public List<WebElement> visitType;

    @FindBy(xpath = "//select[@title='Select an option']")
    public WebElement punctuality;

    @FindBy(xpath = "//div[2]/button[2]/span")
    public WebElement startVisitConfirmBtn;
}


