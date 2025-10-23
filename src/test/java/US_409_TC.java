import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import pages.AddPatientToQueue;
import utilities.ReusableMethods;

public class US_409_TC extends ReusableMethods {

    HomePage homePage;
    LoginPage loginPage;
    AddPatientToQueue addPatientToQueue;
    DemoPage demoPage;
    String username="admin";
    String password="Admin123";
    String patientName="sam";


    @Test
    public void addPatientToQueue() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        addPatientToQueue = new AddPatientToQueue();
        demoPage = new DemoPage();

        driver.get("https://openmrs.org/");
        myClick(homePage.demoBtn);
        jsClick(demoPage.openMrs3Btn);
        mySendKeys(loginPage.userNameInput, username);
        myClick(loginPage.continueLoginBtn);
        mySendKeys(loginPage.passwordInput, password);
        myClick(loginPage.continueLoginBtn);

        myClick(addPatientToQueue.addPatientToQueueBtn);

        myClick(addPatientToQueue.searchInput);

        mySendKeys(addPatientToQueue.searchInput, patientName);

        myClick(addPatientToQueue.startVisitBtn);
    }
}
