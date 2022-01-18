package pages;

import common.DriverInitializer;
import elements.Button;
import elements.TextField;

public class SSBPage extends DriverInitializer {

    public Button enter = new Button("sisene", "xpath=//a[text()='Sisene']");

    public TextField email = new TextField("email", "name=username", "ottkangur89@gmail.com");

    public TextField password = new TextField("password", "name=password", "Liimipulk77");

    public Button login = new Button("continue", "xpath=//button[normalize-space(text())='Jätkan']");
    /**
     * normalize-space() aitab ülearused tühikud ära kaotada
     * nt <button> Jätkan </button>
     * antud juhul tekivad ülearused tühikud tõenäoliselt Chrome' renderdamise käigus
     */
}
