package SelniumTests.Tests;

import SelniumTests.Pages.CartPage;
import SelniumTests.Pages.InventoryPage;
import SelniumTests.Pages.LoginPage;
import SelniumTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cart extends TestBase {
//      user story 5,6
//    User can remove items from cart page
//    User can return to inventory page from cart page

    @Test
    public void removeFromCart(){
        driver.get("https://www.saucedemo.com");
        new LoginPage().login();
        new InventoryPage().add("Bike");
        new InventoryPage().add("Fleece");
        CartPage cartPage=new CartPage();
        cartPage.ShoppingCart.click();
        cartPage.remove("Bike");

    }

    @Test
    public void cartContinueShopping(){
        driver.get("https://www.saucedemo.com");
        new LoginPage().login();
        CartPage cartPage=new CartPage();
        cartPage.ShoppingCart.click();
        cartPage.ContinueShopping.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

}
