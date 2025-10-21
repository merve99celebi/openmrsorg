package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class FindPatientPage extends ReusableMethods {
    public FindPatientPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div input")
    public WebElement searchBarInput;

    @FindBy(css = "tr td:nth-child(1)")
    public WebElement searchBarResult;

    @FindBy(css = "div h2")
    public WebElement findPatientText;
}
