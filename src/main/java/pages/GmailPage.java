package pages;

import elements.Button;
import elements.TextField;

public class GmailPage {

    //email field
    public TextField invalidEmail = new TextField("email", "name=identifier", "smrndmnpt");

    public TextField validEmail = new TextField("email", "name=identifier", "ottkangur89");

    public TextField invalidPassword = new TextField("password", "name=???", "wrongPass");

    public TextField validPassword = new TextField("password", "name=???", "Liimipulk77");

    public Button next = new Button("next", "xpath=//span[text()='Järgmine']");
}
