package SelniumTests.Pages;

import SelniumTests.Utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {        PageFactory.initElements(Driver.get(),this);    }

    @FindBy(className = "shopping_cart_link")
    public WebElement ShoppingCart;

    @FindBy(id="react-burger-menu-btn")
    public WebElement menu;

    @FindBy(id="logout_sidebar_link")
    public  WebElement Logout;

    public void logout(){
        menu.click();Logout.click();
    }



}
