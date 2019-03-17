package pages;

import elements.Button;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLogOnPage extends BasePage {

    private By newCustomerButtonSelector = By.cssSelector("a.btn.btn-default.login-btn");
    private By customerEmailAddressSelector = By.cssSelector("div.form-group.login-page input[name='signin_userName']");
    private By customerPasswordSelector = By.cssSelector("div.form-group.login-page input[name='signin_password']");
    private By signInButtonSelector = By.cssSelector("button.btn.btn-default.login-btn");

    private Button newCustomerButton;
    private TextInput customerEmailAddress;
    private TextInput customerPassword;
    private Button signInButton;


    public CustomerLogOnPage(WebDriver driver) {
        super(driver);
        this.newCustomerButton = new Button(driver, newCustomerButtonSelector);
        this.customerEmailAddress = new  TextInput(driver, customerEmailAddressSelector);
        this.customerPassword = new TextInput(driver, customerPasswordSelector);
        this.signInButton = new Button(driver, signInButtonSelector);
    }

    public void createNewAccount(){
        this.newCustomerButton.click();
    }
}
