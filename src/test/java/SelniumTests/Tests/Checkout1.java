package SelniumTests.Tests;

import SelniumTests.Pages.CartPage;
import SelniumTests.Pages.Checkout1Page;
import SelniumTests.Pages.LoginPage;
import SelniumTests.TestBase;
import SelniumTests.Utility.ConfigurationReader;
import SelniumTests.Utility.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Checkout1 extends TestBase {
//    User can not checkout with invalid credentials
    //initialize the class
//    ExtentReports report=new ExtentReports();
    //create a report path
//    String path=System.getProperty("user.dir")+"/test-output/Screenshots/AAAA20.html";
    //initialize the html reporter with the report path
//    ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(path);

//    ExtentTest extentLogger;
//    @BeforeMethod
//    public  void before(){
//        report.attachReporter(htmlReporter);
//        htmlReporter.config().setReportName("Selenium Class Report 1");
//        report.setSystemInfo("Environment", "QA");
//        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
//
//    }
//    @AfterMethod
//    public void afterMethod(ITestResult result) throws IOException {
//        //if test failed
//        if(result.getStatus()==ITestResult.FAILURE){
//            //record the name fo failed test case
//            extentLogger.fail(result.getName());
//            //form the name of the screenshot
//            String date=new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
//            // creates screenshot object by downcasting driver class
//            TakesScreenshot ts= (TakesScreenshot) Driver.get();
//            // takes screenshot to temp folder
//            File file= ts.getScreenshotAs(OutputType.FILE);
//            // give a location to save the screenshot
//            String target=System.getProperty("user.dir")+"/test-output/Screenshots/"+result.getName()+date+".png";
//            File finaldest= new File(target);
//            // copy the file in temp folder to screenshot folder
//            FileUtils.copyFile(file,finaldest);
//            // add the screenshot to the report
//            extentLogger.addScreenCaptureFromPath(result.getName()+date+".png");
//            extentLogger.fail(result.getThrowable());
//
//        }
//
//
//    }
//
//
//
//    @AfterTest
//            public void after(){
//        // finalize the report
//        report.flush();
//    }



Checkout1Page checkout1Page=new Checkout1Page();
    @Test
    public void validUserInformation(){
        extentLogger=report.createTest("validUserInformation 1");
        extentLogger.info("User goes to the web page");
        driver.get("https://www.saucedemo.com");
        new LoginPage().login();
        extentLogger.info("User login with Valid credentials");
        checkout1Page.ShoppingCart.click();
        extentLogger.info("User goes to Shopping Cart");
        new CartPage().checkout.click();
        extentLogger.info("User goes to checkout 1");
        checkout1Page.ConfirmInformation("Mike","Smith", "LA");
        Assert.assertTrue(driver.getCurrentUrl().contains("step-twot"));
        extentLogger.pass("User sucess");
    }
    @Test
    public void invalidUser1(){
        extentLogger=report.createTest("invalidUser 1");
        preCondition();
        checkout1Page.ConfirmInformation("","", "");
        extentLogger.info("User is in Checkout Page");
        String str=checkout1Page.ErrorMessage.getText();
        Assert.assertTrue(str.contains("Error"));
        extentLogger.pass("Cannot checkout");

    }
    @Test
    public void invalidUser2(){
        extentLogger=report.createTest("invalidUser 2");
        preCondition();
        checkout1Page.ConfirmInformation("#","%", "&");
        try {
            String str = checkout1Page.ErrorMessage.getText();
            Assert.assertTrue(str.contains("Error"));
            extentLogger.pass("Cannot checkout");
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
