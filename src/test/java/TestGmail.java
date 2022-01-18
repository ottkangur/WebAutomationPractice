import common.DriverInitializer;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GmailPage;

public class TestGmail extends DriverInitializer {

    @BeforeTest
    private void openGmail(){
        initialiseWebDriver("https://www.gmail.com");
    }

    @Test
    public void gmailTest(){
        System.out.println("opened");


        GmailPage gmailPage = new GmailPage();
        gmailPage.validEmail.setValue();
        System.out.println("set");

        gmailPage.next.clickButton();
        System.out.println("clicked");


    }
}
