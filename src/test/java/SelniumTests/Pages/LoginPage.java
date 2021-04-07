package SelniumTests.Pages;

import SelniumTests.Utility.ConfigurationReader;
import SelniumTests.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import SelniumTests.Utility.Driver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() { PageFactory.initElements(Driver.get(),this);      }

    @FindBy(id = "user-name")
    public WebElement Username;

    @FindBy (id = "password")
    public WebElement Password;

    @FindBy(id = "login-button")
    public WebElement LoginButton;

    @FindBy(className = "error-button")
    public WebElement ErrorMessage;

    public void login(){
//        LoginPage loginPage=new LoginPage();
        String user=ConfigurationReader.get("username");
        String pass=ConfigurationReader.get("password");
        Username.sendKeys(user);
        Password.sendKeys(pass);
        LoginButton.click();
    }

    public void  login(String userr,String passs){
        Username.sendKeys(userr);
        Password.sendKeys(passs);
        LoginButton.click();
        Assert.assertTrue(ErrorMessage.getText().contains("Epic sadface"));
    }











//
//    @FindBy(id = "user-name")
//    public WebElement username;
//
//    @FindBy(id="password")
//    public WebElement password;
//
//    @FindBy(id="login-button")
//    public  WebElement loginButton;
//
//    public  void loginnot(String user,String pass){
//        username.sendKeys(user);
//        password.sendKeys(pass);
//        loginButton.click();
//    }
//
//    public  void login(){
//        String user= ConfigurationReader.get("username");
//        String pass= ConfigurationReader.get("password");
//        username.sendKeys(user);
//        password.sendKeys(pass);
//        loginButton.click();
//    }


}
