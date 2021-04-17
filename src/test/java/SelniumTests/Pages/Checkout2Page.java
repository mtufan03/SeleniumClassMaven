package SelniumTests.Pages;

import SelniumTests.Utility.Driver;
import SelniumTests.WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Checkout2Page {
    public Checkout2Page() {        PageFactory.initElements(Driver.get(),this);    }




    @FindBy(className = "inventory_item_name")
    public List<WebElement> ItemsList;
    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> RemoveButtons;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> ItemsPriceList;
    @FindBy(className = "summary_subtotal_label")
    public  WebElement subTotal;

    @FindBy(id="cancel")
    public WebElement cancelButton;

    @FindBy(id="finish")
    public WebElement finishButton;

    @FindBy(className = "complete-header")
    public WebElement confheader;

    public void confirmOrder(){
        String Actual=confheader.getText();
        Assert.assertEquals(Actual,"THANK YOU FOR YOUR ORDER");
        System.out.println("THANK YOU FOR YOUR ORDER");
    }


    public  void remove(String str){
        for( int i=0; i<ItemsList.size(); i++){
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
