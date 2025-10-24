package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import java.util.List;

public class RegisterAPatient extends ReusableMethods {
    public RegisterAPatient() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@aria-label='Add patient']")
    public WebElement addPatientBtn;

    @FindBy(xpath = "//input[@id='givenName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='familyName']")
    public WebElement familyName;

    @FindBy(css = "div[class='cds--radio-button-wrapper']")
    public WebElement gender;

    @FindBy(css = "div[id='birthdate']")
    public WebElement birth;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement adress1;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement adress2;

    @FindBy(xpath = "//input[@id='cityVillage']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='stateProvince']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='postalCode']")
    public WebElement postalCode;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//button[@class='-esm-patient-registration__patient-registration__submitButton___Ps1do cds--btn cds--btn--primary']")
    public WebElement registerPatientBtn;

    @FindBy(xpath = "(//span[@class='cds--content-switcher__label'])[4]")
    public WebElement dateofBirthNoBtn;

    @FindBy(xpath = "//input[@id='yearsEstimated']")
    public WebElement estimatedAgeBtn;









}




