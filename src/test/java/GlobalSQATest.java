import common.DriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GlobalSQA;

import java.util.concurrent.TimeUnit;

public class GlobalSQATest extends DriverInitializer {

    @BeforeTest
    public void openChrome(){
        initialiseWebDriver("https://www.globalsqa.com/demo-site/");
    }

    @AfterTest
    public void closeChrome(){
        getWebDriver().quit();
    }

    @Test
    public void andersTest(){
        GlobalSQA globalSQA = new GlobalSQA();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)getWebDriver();
        javascriptExecutor.executeScript("scroll(0, 350)");
        globalSQA.autoCompleteButton.clickButton();

        //search field is inside impeded html, therefore that html (iframe element) has to be switched to
        WebElement frameOnPage = getWebDriver().findElement(By.className("demo-frame"));
        getWebDriver().switchTo().frame(frameOnPage);

        globalSQA.searchField.setValue();
        globalSQA.anders.clickButton();
        System.out.println("ander andersson selected");
    }
}
