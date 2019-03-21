package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingShippingPage extends BasePage {

    private Button billingAdressEdit;
    private By billingAdressEditSelector = By.xpath("//*[contains(text(),'Billing Address')]/a");

    private Button shippingAddress;
    private By shippingAdddressSelector = By.xpath("//*[contains(text(),'Shipping Address')]/a");

    public BillingShippingPage(WebDriver driver){
        super(driver);
    }



}
