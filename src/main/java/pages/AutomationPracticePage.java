package pages;

import elements.Button;
import elements.RandomText;
import elements.TextField;

public class AutomationPracticePage {
    public Button womenButton = new Button("Women", "xpath=//a[text()='Women']");
    public TextField searchField = new TextField("Search", "name=search_query", "Blouse");
    public Button submitButton = new Button("Submit", "name=submit_search");
    public RandomText productName = new RandomText("Product", "xpath=//div[@class='product-container']//a[@class='product-name']");

    public Button dressesButton = new Button("Dresses", "xpath=//a[text()='Dresses']");
    public Button sortByDropDown = new Button("Sort by", "id=selectProductSort");
    public Button aToZ = new Button("A to Z", "xpath=//option[text()='Product Name: A to Z']");

    public Button products = new Button("Products", "class=product_list");

    public Button firstProduct = new Button("Product 1", "xpath=//ul[@class='product_list grid row']/li[1]//div[@class='left-block']");
    public Button close = new Button("Close", "class=fancybox-close");

    public Button myStore = new Button("My Store", "xpath=//a[@title='My Store']");
    public Button nextPicture = new Button("Next", "class=bx-next");
}
