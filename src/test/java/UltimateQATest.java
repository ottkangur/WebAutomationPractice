import com.aventstack.extentreports.Status;
import common.DriverInitializer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class UltimateQATest extends DriverInitializer {

    @BeforeTest
    private void openPage(){
        initialiseWebDriver("https://ultimateqa.com/simple-html-elements-for-automation/");
        System.out.println("opened");
    }

    @AfterTest
    private void closeChrome(){
        getWebDriver().quit();
    }

    @Test
    public void test1(){
        try{Thread.sleep(5000);}
        catch (Exception ex) {System.out.println("Waiting for 5 sec to page to load");}

//        //clicking Email Me
        HomePage homePage = new HomePage();
//        homePage.emailMe.clickButton();
//        System.out.println("Email me clicked");

        //filling fields
        homePage.name.setValue();
        homePage.email.setValue();
        System.out.println("fields filled");

        //click Email me
        homePage.emailMe.clickButton();
        System.out.println("Email me clicked");

        //does validation text appear - this part also fails sometimes
        String invalidEmail = homePage.invalidEmail.textOnPage();
        if (homePage.invalidEmail.isTrue()){
            System.out.println("email was invalid");
//            testReport.log(Status.INFO, "Validation info appeared: '" + invalidEmail + "'");
        } else {
            System.out.println("smt went wrong");
        }
    }

    @Test
    public void test2(){
        System.out.println("2nt test");
    }

}
