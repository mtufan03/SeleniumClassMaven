package SelniumTests.Tests;

import SelniumTests.TestBase;
import SelniumTests.Utility.ConfigurationReader;
import SelniumTests.Utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login extends TestBase {


    @Test
    public void test1(){
        String url=ConfigurationReader.get("url");
        driver.get(url);


        String brow=ConfigurationReader.get("browser");
        System.out.println(brow);


        Driver.closeDriver();


    }
}
