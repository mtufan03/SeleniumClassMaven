package SelniumTests.Pages;

import SelniumTests.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BasePage {
    public InventoryPage() {        PageFactory.initElements(Driver.get(),this);    }


    @FindBy(className = "inventory_item_name")
    public List<WebElement> ItemName;
    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> RemoveButtons;
    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> AddButtons;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> ItemsPriceList;

    public void add(String str){
        for( int i=0; i<ItemName.size(); i++){
            if(ItemName.get(i).getText().contains(str)){
                AddButtons.get(i).click();
            }
        }

    }

    public  void remove(String s){

    }

    public int getPrice(String str){
        int a=0;
        return a;
    }



}
