package SelniumTests.Tests;

import SelniumTests.Pages.*;
import SelniumTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout2 extends TestBase {
//    User has to pay the addition of items cost in checkout
//    User can cancel the payment during the checkout

    double sum=0;
    @Test
    public void preCondition() {
    driver.get("https://www.saucedemo.com");
    new LoginPage().login();
    InventoryPage inventoryPage=new InventoryPage();
        sum+=inventoryPage.add("Bike");

        System.out.println("Bike" +sum);
        sum+=inventoryPage.add("Backpack");
        System.out.println("BackPAck"+sum);
        sum+=inventoryPage.add("Jacket");
//    sum+=inventoryPage.getPrice("Jacket");
        System.out.println("Jacket"+sum);
//    sum+=inventoryPage.getPrice("Backpack");

    inventoryPage.ShoppingCart.click();
    new CartPage().checkout.click();
    new Checkout1Page().ConfirmInformation("a","b","c");
    Checkout2Page checkout2Page=new Checkout2Page();
    String str=checkout2Page.subTotal.getText().substring(13);

    double subTotal=Double.parseDouble(str);
        Assert.assertEquals(sum,subTotal);
    new Checkout2Page().finishButton.click();
    new Checkout2Page().confirmOrder();

}


}
