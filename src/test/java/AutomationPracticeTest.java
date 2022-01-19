import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.DriverInitializer;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pages.AutomationPracticePage;

import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class AutomationPracticeTest extends DriverInitializer {
    static ExtentReports report;
    static ExtentTest testReport;
    AutomationPracticePage automationPracticePage = new AutomationPracticePage();

    @BeforeClass
    public void startTest() {
        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(
                System.getProperty("user.dir")
                        + File.separator + "reports"
                        + File.separator + "TestResults.html");
        report.attachReporter(spark);
    }

    @AfterClass
    public void endTest() {
        report.flush();
    }

    @BeforeTest
    public void openChrome() {
        initialiseWebDriver("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void closeChrome() {
        getWebDriver().quit();
    }

    @Test(enabled = true, priority = 0)
    public void blouseTest() {
        testReport = report.createTest("Blouse report");
        automationPracticePage.womenButton.clickButton();
        testReport.log(Status.INFO, "\"Women\" button clicked");
        automationPracticePage.searchField.setValue();
        testReport.log(Status.INFO, "Search value set to \"Blouse\" ");
        automationPracticePage.submitButton.clickButton();
        testReport.log(Status.INFO, "Search started");
        String expectedResult = "Blouse";

        assertEquals(automationPracticePage.productName.textOnPage(), expectedResult);
    }

    @Test(enabled = true, priority = 1, groups = {"dress"})
    public void dressesTest() {
        initialiseWebDriver("http://automationpractice.com/index.php");
//        ExtentReports internalReport = new ExtentReports();
        testReport = report.createTest("Dresses report");
        automationPracticePage.dressesButton.clickButtonJS();
        testReport.log(Status.INFO, "\"Dresses\" button clicked");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        javascriptExecutor.executeScript("scroll(0, 900)");
        automationPracticePage.sortByDropDown.clickButton();
        testReport.log(Status.INFO, "\"Dropdown\" button clicked");
        automationPracticePage.aToZ.clickButton();
        testReport.log(Status.INFO, "A to Z selected");
        String screenshot = "data:image/png;base64," + ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BASE64);
        testReport.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot, "A to Z").build());
    }

    @Test(enabled = true, priority = 0)
    public void womenProductsTest() {
        testReport = report.createTest("Women products report");
        automationPracticePage.womenButton.clickButton();
        testReport.log(Status.INFO, "\"Women\" button clicked");
        List<WebElement> allProductsList = automationPracticePage.products.returnElementsList();
        for (int i = 1; i <= allProductsList.size(); i++) {
            testReport.log(Status.INFO,
                    "Item " + i + ": "
                            + allProductsList.get(i - 1).findElement(By.className("product-name")).getText());
        }

        /**hard to use indices with forEach loop*/
//        allProductsList.forEach(el ->
//                    testReport.log(Status.INFO, "Item: " + el.findElement(By.className("product-name")).getText())
//        );

        testReport.log(Status.PASS, "All " + allProductsList.size() + " items logged");
    }

    @Test(enabled = true, priority = 1, groups = {"dress"})
    public void pickDressTest() {
        testReport = report.createTest("Dress test", "Picking one dress");
        automationPracticePage.dressesButton.clickButtonJS();
        testReport.log(Status.INFO, "\"Dresses\" button clicked");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        javascriptExecutor.executeScript("scroll(0, 700)");
        automationPracticePage.firstProduct.clickButton();
        testReport.log(Status.INFO, "First product clicked");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String screenshot = "data:image/png;base64," + ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BASE64);
        testReport.log(Status.INFO, "First dress captured");
        testReport.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot, "First dress pop-up").build());
        automationPracticePage.close.clickButton();
        testReport.log(Status.PASS, "Pop-up closed");
    }

    @Test(enabled = true, priority = 2)
    public void nextInteractivePicture() {
        testReport = report.createTest("Next picture test");
        automationPracticePage.myStore.clickButton();
        testReport.log(Status.INFO, "Home page opened");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        javascriptExecutor.executeScript("scroll(0, 100)");
        String screenshotBefore = "data:image/png;base64," + ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BASE64);
        testReport.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBefore, "Before click").build());
        automationPracticePage.nextPicture.clickButton();
        testReport.log(Status.INFO, "Next arrow clicked");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String screenshotAfter = "data:image/png;base64," + ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BASE64);
        testReport.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotAfter, "After click").build());
    }

}
