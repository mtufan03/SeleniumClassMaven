package SelniumTests.Tests;

import SelniumTests.Pages.InventoryPage;
import SelniumTests.Pages.LoginPage;
import SelniumTests.TestBase;
import org.testng.annotations.Test;

public class Inventory extends TestBase {
//    User Story 3
//    User can Select and Add items to the cart from Inventory Page


    @Test
    public void addItem(){
        driver.get("https://www.saucedemo.com/inventory.html");
        new LoginPage().login();
//        LoginPage loginPage=new LoginPage();
//        loginPage.login();
        InventoryPage inventoryPage=new InventoryPage();
//        String s0=inventoryPage.ItemName.get(1).getText();
//        System.out.println(s0);
        inventoryPage.add("Fleece Jacket");
        inventoryPage.add("pike");

        inventoryPage.logout();


    }

    @Test
    public  void  removeItem() throws InterruptedException {

        driver.get("https://www.saucedemo.com/inventory.html");
        new LoginPage().login();

        InventoryPage inventoryPage=new InventoryPage();
        inventoryPage.add("Bike");
        inventoryPage.add("Fleece Jacket");
        Thread.sleep(3000);
        inventoryPage.remove("Bike");


    }


}
