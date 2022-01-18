package pages;

import elements.Button;
import elements.RandomText;
import elements.TextField;

public class HomePage {

    //test 1
    public Button emailMe = new Button("Email me", "name=et_builder_submit_button");

    public Button clickMe = new Button("Click me", "xpath=//a[text()='Click Me']");

    public TextField name = new TextField("Name", "id=et_pb_contact_name_0", "John Doe");

    public TextField email = new TextField("Email", "id=et_pb_contact_email_0", "jd");

    public RandomText pleaseFillFields = new RandomText("Please", "xpath=//p[text()='Please, fill in the following fields:']");

    public RandomText invalidEmail = new RandomText("Invalid email", "xpath=//li[text()='Invalid email']");

    public RandomText link = new RandomText("Link", "xpath=//span[text()='Link']");

    //test 5
    public Button xpathButton = new Button("Xpath Button ", "xpath=//div[contains(@class, 'et_pb_blurb_12')]//button[@id='button1']");

//    public RandomText title = new RandomText("Button success", "xpath=//title[text()='Button success']");

    //test 6
    public Button dropdown = new Button("Cars", "xpath=//select");
}
