package SelniumTests.Pages;

import SelniumTests.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Checkout1Page {



    public Checkout1Page() {        PageFactory.initElements(Driver.get(),this);    }




    @FindBy(id = "first-name")
    public WebElement FirstName;

    @FindBy(id = "last-name")
    public WebElement LastName;

    @FindBy(id = "postal-code")
    public WebElement PostalCode;

    @FindBy(id = "continue")
    public WebElement ContinueButton;

    @FindBy(id = "cancel")
    public WebElement CancelButton;

    public void ConfirmInformation(String a, String b,String c){
        FirstName.sendKeys(a);
        LastName.sendKeys(b);
        PostalCode.sendKeys(c);
        ContinueButton.click();

    }


}
