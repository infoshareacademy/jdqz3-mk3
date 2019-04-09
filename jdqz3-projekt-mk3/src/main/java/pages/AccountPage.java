package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private Button myAccount;
    private By myAccountSelector = By.cssSelector("[href='/shop/customer/dashboard.html']");

    private Button billingShippingInformation;
    private By billingShippingInformationSelector = By.cssSelector("[href='/shop/customer/billing.html']");

    private Button changePassword;
    private By changePasswordSelector = By.cssSelector("[href='/shop/customer/password.html']");

    private Button logout;
    private By logoutSelector = By.cssSelector("ul.nav-list [href='/shop/customer/logout']");

    private Button recentOrders;
    private By recentOrdersSelector = By.cssSelector("[href='/shop/customer/orders.html']");


    private Button shippingAddress;
    private By shippingAdddressSelector = By.xpath("//a[contains(text(),'Add a new address')]");

    private Button billingAdressEdit;
    private By billingAdressEditSelector = By.xpath("//*[contains(text(),'Billing Address')]/a");

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public void logoutUser() {
        this.logout = new Button(driver, logoutSelector);
        logout.click();
    }

    public void goToChangePasswordPage() {
        this.changePassword = new Button(driver, changePasswordSelector);
        changePassword.click();
    }

    public void goToBillingAndShippingInformation() {
        this.billingShippingInformation = new Button(driver, billingShippingInformationSelector);
        billingShippingInformation.click();
    }

    public void clickAddANewAddress() {
        this.shippingAddress = new Button(driver, shippingAdddressSelector);
        shippingAddress.click();
    }

    public void clickBillingAddresEditButton(){
        this.billingAdressEdit = new Button(driver, billingAdressEditSelector);
        billingAdressEdit.click();
    }
}
