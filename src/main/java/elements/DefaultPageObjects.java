package elements;

import common.DriverInitializer;

public class DefaultPageObjects extends DriverInitializer {
    private String name;
    private String locator;
    private String value;

    public DefaultPageObjects() {
    }

    //for just finding element
    public DefaultPageObjects(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    //for finding element and filling field
    public DefaultPageObjects(String name, String locator, String value) {
        this.name = name;
        this.locator = locator;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getLocator() {
        return locator;
    }

    public String getValue() {
        return value;
    }

    public void clearField(){
        getWebElement(getLocator()).clear();
    }

}
