package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Button extends DefaultPageObjects {
    public Button(String name, String locator) {
        super(name, locator);
    }

    public void clickButton() {
        WebElement button = getWebElement(getLocator());
        button.click();
    }

    public void clickButtonJS() {
        WebElement button = getWebElement(getLocator());
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        javascriptExecutor.executeScript("arguments[0].click();", button);
    }

    public List<WebElement> returnElementsList() {
        WebElement allElements = getWebElement(getLocator());
        return allElements.findElements(By.xpath("*"));
    }

}
