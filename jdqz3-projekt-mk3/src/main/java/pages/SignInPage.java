package pages;

import elements.Button;
import elements.Label;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    private By customerEmailAddressSelector = By.id("signin_userName");
    private By signInPasswordSelector = By.id("signin_password");
    private By signInButtonSelector = By.id("genericLogin-button");
    private By loginErrorMessageSelector = By.id("loginError");
    private By newCustomerButtonSelector = By.cssSelector("a.btn.btn-default.login-btn");

    private TextInput customerEmailAddress;
    private TextInput signInPassword;
    private Button signInButton;
    private Label loginErrorMessage;
    private Button newCustomerButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.customerEmailAddress = new TextInput(driver, customerEmailAddressSelector);
        this.signInPassword = new TextInput(driver, signInPasswordSelector);
        this.newCustomerButton = new Button(driver, newCustomerButtonSelector);
    }

    public void clickSignInButton(){
        this.signInButton = new Button(driver, signInButtonSelector);
        this.signInButton.click();
    }

    public String isMessageForEmptyCredentialsCorrect() {
        this.loginErrorMessage = new Label(driver, loginErrorMessageSelector);
        String messageForEmptyCredentials = loginErrorMessage.readLabel();
        return messageForEmptyCredentials;
    }

    public void createNewAccount(){
        this.newCustomerButton.click();
    }
}
