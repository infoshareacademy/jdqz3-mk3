package pages;

import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterRegistrationPage extends  BasePage{

    private By shoppingCartSelector = By.xpath("//a[starts-with(text(), 'Shopping cart')]");
    private Label shoppingCartAmmount;

    private By loginNameInNavBarSelector = By.cssSelector("div.header-top-left span");
    private Label loginNameInNavBar;


    public AfterRegistrationPage(WebDriver driver) {
        super(driver);
        this.shoppingCartAmmount = new Label(driver, shoppingCartSelector);
        this.loginNameInNavBar = new Label(driver, loginNameInNavBarSelector);
    }

    public String getShoppingCardAmound(){
        return this.shoppingCartAmmount.readLabel();
    }

    public String getLoginFromNavBar(){
        return this.loginNameInNavBar.readLabel();
    }


}
