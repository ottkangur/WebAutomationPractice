package elements;

import org.openqa.selenium.WebElement;

public class TextField extends DefaultPageObjects{
    public TextField(String name, String locator, String value){
        super (name, locator, value);
    }

    public void setValue(){
        WebElement field = getWebElement(getLocator());
        field.sendKeys(getValue());
    }
}
