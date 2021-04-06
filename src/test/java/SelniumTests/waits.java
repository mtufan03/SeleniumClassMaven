package SelniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class waits {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,10);
    }
    int a=6;
    long b=a;  // implicit casting
    short c=(short)a; //explicit casting

    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void waits(){
        driver.get("https://demoqa.com/dynamic-properties");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement visibleAfter=driver.findElement(By.id("visibleAfter"));
//        String str=visibleAfter.getText();
//        System.out.println(str);
        WebElement enable=driver.findElement(By.id("enableAfter"));
        System.out.println("Before wait = "+enable.isEnabled());

//        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(enable));

        System.out.println("After Wait = "+enable.isEnabled());


    }

    @Test
    public  void links(){
//        driver.get("https://demoqa.com/links");
//        WebElement homeLink=driver.findElement(By.linkText("Home"));
//        homeLink.click();

        driver.get("https://demoqa.com/broken");

        WebElement valid=driver.findElement(By.linkText("Click Here for Valid Link"));

        String s=valid.getAttribute("href");
        System.out.println(s);
        verifyLinks(s);

        WebElement broken=driver.findElement(By.partialLinkText("Broken Link"));
        String st=broken.getAttribute("href");
        System.out.println(st);
        verifyLinks(st);

    }




    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }


}
