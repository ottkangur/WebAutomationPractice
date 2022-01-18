package elements;

import common.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements extends DriverInitializer {
//    private String name;
//    private String locator;
//    private String value;

    public PageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user[email]")
    private WebElement email;

    @FindBy(id = "user[password]")
    private WebElement password;

    @FindBy(className = "button button-primary g-recaptcha")    //why it cannot be found?
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='et_pb_contact_name_0']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='et_pb_contact_email_0']")
    private WebElement email4;

    @FindBy(className = "product_list")
    private WebElement womenProducts;

    public boolean isInitialized() {
        return email.isDisplayed();
    }

    public void fillFields(String email, String password){
        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);
    }

    public void click(){
        this.signInButton.click();
    }

    public void fillFields4(String name, String email){
        this.name.clear();
        this.name.sendKeys(name);

        this.email4.clear();
        this.email4.sendKeys(email);
    }

    public void returnProductNames(){
//        this.productNames.
    }

}
