package pages;

import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterRegistrationPage extends  BasePage{

    private By shoppingCartSelector = By.xpath("//a[starts-with(text(), 'Shopping cart')]");
    private Label shoppingCartAmmount;

    public AfterRegistrationPage(WebDriver driver) {
        super(driver);
        this.shoppingCartAmmount = new Label(driver, shoppingCartSelector);
    }

    public String getShoppingCardAmound(){
        return this.shoppingCartAmmount.readLabel();
    }
}
