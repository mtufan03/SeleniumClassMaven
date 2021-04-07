package SelniumTests.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage {


    @FindBy(className = "inventory_item_name")
    public List<WebElement> ItemsList;
    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> removeButtons;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> ItemsPriceList;
    @FindBy (id="continue-shopping")
    public WebElement ContinueShopping;
    @FindBy (xpath = "checkout")
    public WebElement checkout;



}
