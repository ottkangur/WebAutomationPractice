package pages;

import elements.Button;
import elements.Frame;
import elements.RandomText;
import elements.TextField;

public class GlobalSQA {
    public Button autoCompleteButton = new Button("AutoComplete", "xpath=//a[text()='AutoComplete']");
    public Frame frame = new Frame("Frame", "class=demo-frame");
    public TextField searchField = new TextField("Search", "xpath=//input[@class='ui-autocomplete-input']", "and");
    public Button anders = new Button("anders andersson", "xpath=//div[text()='anders andersson']");
}
