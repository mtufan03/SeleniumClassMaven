package SelniumTests.Tests;

import SelniumTests.Pages.InventoryPage;
import SelniumTests.Pages.LoginPage;
import SelniumTests.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Inventory extends TestBase {
//    User Story 3
//    User can Select and Add items to the cart from Inventory Page

    ExtentReports report=new ExtentReports();
    String path=System.getProperty("user.dir")+"/test-output/Screenshots/AABreport.html";
    ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(path);
    protected static ExtentTest extentLogger;
    @BeforeMethod
    public void setup(){
    report.attachReporter(htmlReporter);
    htmlReporter.config().setReportName("VyTrack Smoke Test");
    report.setSystemInfo("Environment", "QA");
    report.setSystemInfo("Browser", "Chrome");
    }

    @AfterMethod()
    public void after(){
        report.flush();
    }




    @Test
    public void addItem() throws InterruptedException {
        extentLogger=report.createTest("Test for Inventory");
        extentLogger.info("AAA");

        driver.get("https://www.saucedemo.com/inventory.html");
        new LoginPage().login();
//        LoginPage loginPage=new LoginPage();
//        loginPage.login();
        InventoryPage inventoryPage=new InventoryPage();
//        String s0=inventoryPage.ItemName.get(1).getText();
//        System.out.println(s0);
        inventoryPage.add("Fleece Jacket");
        Thread.sleep(3000);
        inventoryPage.add("Bike");
        Thread.sleep(3000);
        inventoryPage.logout();


    }

//    User can Remove items from Inventory Page
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
