package elements;

public class RandomText extends DefaultPageObjects{
    public RandomText(String name, String locator) {
        super(name, locator);
    }

    public boolean isTrue(){
        return getWebElement(getLocator()).isDisplayed();
    }

    public String textOnPage (){
        return getWebElement(getLocator()).getText();
    }
}
