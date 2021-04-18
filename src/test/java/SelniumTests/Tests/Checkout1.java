package SelniumTests.Tests;

import SelniumTests.Pages.CartPage;
import SelniumTests.Pages.Checkout1Page;
import SelniumTests.Pages.LoginPage;
import SelniumTests.TestBase;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout1 extends TestBase {
//    User can not checkout with invalid credentials
Checkout1Page checkout1Page=new Checkout1Page();
    @Test
    public void validUserInformation(){
        preCondition();
        checkout1Page.ConfirmInformation("Mike","Smith", "LA");
        Assert.assertTrue(driver.getCurrentUrl().contains("step-two"));
    }
    @Test
    public void invalidUser1(){
        preCondition();
        checkout1Page.ConfirmInformation("","", "");
        String str=checkout1Page.ErrorMessage.getText();
        Assert.assertTrue(str.contains("Error"));

    }
    @Test
    public void invalidUser2(){
        preCondition();
        checkout1Page.ConfirmInformation("#","%", "&");
        try {
            String str = checkout1Page.ErrorMessage.getText();
            Assert.assertTrue(str.contains("Error"));
        }catch (NoSuchElementException e){
            Assert.assertTrue(driver.getCurrentUrl().contains("step-one"));

        }
    }

    public void preCondition(){
        driver.get("https://www.saucedemo.com");
        new LoginPage().login();
        checkout1Page.ShoppingCart.click();
        new CartPage().checkout.click();
    }

}
