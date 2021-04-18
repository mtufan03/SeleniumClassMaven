package SelniumTests.Pages;

import SelniumTests.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

public CartPage() {        PageFactory.initElements(Driver.get(),this);    }


    @FindBy(className = "inventory_item_name")
    public List<WebElement> ItemsList;
    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> RemoveButtons;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> ItemsPriceList;
    @FindBy (id="continue-shopping")
    public WebElement ContinueShopping;


    @FindBy (id = "checkout")
     public WebElement checkout;

    public  void remove(String str){
        for( int i=0; i<RemoveButtons.size(); i++){
            if(ItemsList.get(i).getText().contains(str)){
                RemoveButtons.get(i).click();
            }
        }
    }

    public int getPrice(String str){
        int a=0;
        for( int i=0; i<ItemsList.size(); i++){
            if(ItemsList.get(i).getText().contains(str)){
                a=Integer.parseInt(ItemsPriceList.get(i).getText());
            }
        }
        return a;
    }


}
