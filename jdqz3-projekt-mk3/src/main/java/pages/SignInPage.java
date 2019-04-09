package pages;

import elements.Button;
import elements.Label;
import elements.TextInput;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    private By customerEmailAddressSelector = By.id("signin_userName");
    private By signInPasswordSelector = By.id("signin_password");
    private By signInButtonSelector = By.id("genericLogin-button");
    private By loginErrorMessageSelector = By.id("loginError");
    private By newCustomerButtonSelector = By.cssSelector("a.btn.btn-default.login-btn");
    private By welcomeTextUserSelector = By.xpath("//div[@id='customerAccount']/ul/li/a/span");

    private TextInput customerEmailAddress;
    private TextInput signInPassword;
    private Button signInButton;
    private Label loginErrorMessage;
    private Button newCustomerButton;
    private Label welcomeTextUser;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.customerEmailAddress = new TextInput(driver, customerEmailAddressSelector);
        this.signInPassword = new TextInput(driver, signInPasswordSelector);
        this.newCustomerButton = new Button(driver, newCustomerButtonSelector);
    }

    private void insertEmail(User user){
        this.customerEmailAddress.fillingField(user.getEmail());
    }
    private void insertPassword(User user){
        this.signInPassword.fillingField(user.getPassword());
    }

    public void loginAsRegisteredUser(User user) {
        insertEmail(user);
        insertPassword(user);
        clickSignInButton();
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

    public String getRegisteredUserFirstName() {
        this.welcomeTextUser = new Label(driver, welcomeTextUserSelector);
        String registeredUserFirstName = welcomeTextUser.readLabel();
        return registeredUserFirstName;
    }

    public void createNewAccount(){
        this.newCustomerButton.click();
    }

    private void insertCustomerEmailAddress(User user){
        this.customerEmailAddress.fillingField(user.getEmail());
    }
    private void insertCustomerPassword(User user){
        this.signInPassword.fillingField(user.getPassword());
    }
    public void insertCustomerDataAndSignIn(User user){
        insertCustomerEmailAddress(user);
        insertCustomerPassword(user);
        clickSignInButton();

    }
}
