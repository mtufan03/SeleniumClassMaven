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

    public double add(String str){
        int a=0;
        for( int i=0; i<ItemName.size(); i++){
            if(ItemName.get(i).getText().contains(str)){
                AddButtons.get(i).click();
            }else{a++;            }
        }
        if(ItemName.size()==a){
        System.out.println(str +" is not in our inventory. Please check your request");}
        return getPrice(str);
    }

        public  void remove(String str){
        int a=0; int n=RemoveButtons.size();
        System.out.println(n);
        for( int i=0; i<n; i++){
            if(ItemName.get(i).getText().contains(str)){
                RemoveButtons.get(i).click();
            }else{a++;}
        }
        if(a==n){
            System.out.println(str+" is not added to the chart yet or not in the list");}
    }

    public double getPrice(String str){
        double a=0;
        for( int i=0; i<ItemName.size(); i++){
            if(ItemName.get(i).getText().contains(str)){
                a=Double.parseDouble(ItemsPriceList.get(i).getText().substring(1));
            }
        }
        return a;
    }



}
