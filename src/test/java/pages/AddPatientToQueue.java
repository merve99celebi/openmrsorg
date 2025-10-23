package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

public class AddPatientToQueue extends ReusableMethods {

    @FindBy(xpath = "//button[@aria-label='Search Patient Button']")
    public WebElement addPatientToQueueBtn;

    @FindBy(xpath = "//input[@id='search-input-:r13v:']")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@aria-label='Start visit']")
    public WebElement startVisitBtn;
}


