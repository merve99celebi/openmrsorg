import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import pages.AddPatientToQueue;
import utilities.ReusableMethods;

import java.util.Random;

public class US_409_TC extends ReusableMethods {

    String username = "admin";
    String password = "Admin123";
    String patientName = "sam";
    String selectValue = "On time";

    @Test
    public void addPatientToQueue() {
        HomePage hp = new HomePage();
        LoginPage lp = new LoginPage();
        AddPatientToQueue aptq = new AddPatientToQueue();
        DemoPage dp = new DemoPage();
        Random random = new Random();

        driver.get("https://openmrs.org/");
        myClick(hp.demoBtn);
        jsClick(dp.openMrs3Btn);
        mySendKeys(lp.userNameInput, username);
        myClick(lp.continueLoginBtn);
        mySendKeys(lp.passwordInput, password);
        myClick(lp.continueLoginBtn);

        myClick(aptq.addPatientToQueueBtn);

        mySendKeys(aptq.searchInput, patientName);

        myClick(aptq.startVisitBtn);

        wait.until(ExpectedConditions.visibilityOfAllElements(aptq.visitType));
        int randomIndex = random.nextInt(aptq.visitType.size());
        myClick(aptq.visitType.get(randomIndex));

        scrollToElement(aptq.punctuality);
        wait.until(ExpectedConditions.visibilityOf(aptq.punctuality));
        Select select = new Select(aptq.punctuality);
        select.selectByVisibleText(selectValue);

        scrollToElement(aptq.startVisitConfirmBtn);
        wait.until(ExpectedConditions.visibilityOf(aptq.startVisitConfirmBtn));
        myClick(aptq.startVisitConfirmBtn);
    }
}
