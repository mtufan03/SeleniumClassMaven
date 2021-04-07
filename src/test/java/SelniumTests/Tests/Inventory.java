package SelniumTests.Tests;

import SelniumTests.Pages.InventoryPage;
import SelniumTests.Pages.LoginPage;
import SelniumTests.TestBase;
import org.testng.annotations.Test;

public class Inventory extends TestBase {

    @Test
    public void test1(){
        driver.get("https://www.saucedemo.com/inventory.html");
        new LoginPage().login();
//        LoginPage loginPage=new LoginPage();
//        loginPage.login();
        InventoryPage inventoryPage=new InventoryPage();
        String s0=inventoryPage.ItemName.get(1).getText();
        System.out.println(s0);
        inventoryPage.add("Fleece Jacket");
        inventoryPage.menu.click();
        inventoryPage.logout();


    }


}
