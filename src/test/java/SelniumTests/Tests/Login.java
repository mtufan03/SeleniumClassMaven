package SelniumTests.Tests;

import SelniumTests.Pages.*;
import SelniumTests.TestBase;
import SelniumTests.Utility.ConfigurationReader;
import SelniumTests.Utility.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class Login extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        String url=ConfigurationReader.get("url");
        driver.get(url);
        LoginPage loginPage=new LoginPage();

//        String user=ConfigurationReader.get("username");
//        String pass=ConfigurationReader.get("password");
//        loginPage.Username.sendKeys(user);
//        loginPage.Password.sendKeys(pass);
//        Thread.sleep(3000);
//        loginPage.LoginButton.click();

//        loginPage.login();
        loginPage.login("Ali","Kurall");





    }


    @Test
    public void test5() throws InterruptedException {
        String url=ConfigurationReader.get("url");
        driver.get(url);


        String brow=ConfigurationReader.get("browser");
        System.out.println(brow);


//        Driver.closeDriver();
        driver.get("https://www.saucedemo.com/");
//        new LoginPage().login();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        System.out.println(new InventoryPage().ItemsList.get(3).getText());
        new InventoryPage().AddButtons.get(3).click();Thread.sleep(2000);
        new InventoryPage().AddButtons.get(4).click();
        new InventoryPage().ShoppingCart.click();Thread.sleep(5000);
//        executor.executeScript("arguments[0].scrollIntoView();", new CartPage().ContinueShopping);
//        driver.findElement(By.id("checkout")).click();
//
//        executor.executeScript("arguments[0].click();", driver.findElement(By.id("checkout")));
//        wait.until(ExpectedConditions.elementToBeClickable(new CartPage().checkout));
//        System.out.println(new CartPage().checkout.getText());Thread.sleep(2000);
        WebElement check;
        do{
         check=driver.findElement(By.id("checkout"));
//        System.out.println(new CartPage().checkout.getText());
        }while(check==null);

        new Checkout1Page().ConfirmInformation("a","bdd","c23");Thread.sleep(2000);
        new Checkout2Page().finishButton.click();
        new Checkout2Page().confirmOrder();



        List<WebElement> items=driver.findElements(By.className("inventory_item_name"));
        System.out.println(items.get(0).getText());
        System.out.println(items.get(1).getText());
        System.out.println(items.get(2).getText());

        System.out.println(new Checkout2Page().ItemsPriceList.get(0).getText());
        System.out.println(new Checkout2Page().ItemsPriceList.get(1).getText());
        System.out.println(new Checkout2Page().ItemsPriceList.get(2).getText());
        new Checkout2Page().finishButton.click();
        new Checkout2Page().confirmOrder();

    }
}
