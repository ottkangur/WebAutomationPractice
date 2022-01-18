import common.DriverInitializer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SSBPage;

public class TestScoreStoryBook extends DriverInitializer {

    @BeforeTest
    private void openSSB(){
        initialiseWebDriver("https://www.scorestorybook.ee");
        System.out.println("open");
    }

    @Test
    public void loginTest(){

        SSBPage ssbPage = new SSBPage();
        ssbPage.enter.clickButton();
        System.out.println("clicked");

        ssbPage.email.setValue();
        ssbPage.password.setValue();
        ssbPage.login.clickButton();
//        ssbPage.test1.clickButton();
//        ssbPage.test2.clickButton();
        System.out.println("logged in");
    }
}
