package pages;

import elements.Button;
import elements.TextInput;
import models.Address;
import elements.Select;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends BasePage {
    private TextInput firstName;
    private TextInput lastName;
    private Select country;
    private TextInput state;

    private TextInput emailAddress;
    private TextInput password;
    private TextInput repeatPassword;

    private Button createAnAccButton;

    private By firstNameSelector = By.cssSelector("div.form-group input[title='First name is required']");
    private By lastNameSelector = By.cssSelector("div.form-group input[title='Last name is required']");
    private By countrySelecotr = By.cssSelector("div.form-group select#registration_country");
    private By stateSelector = By.cssSelector("div.form-group input[title='State / Province is required']");
    private By emailAddressSelector = By.cssSelector("div.form-group input[title='Email address is required']");
    private By passwordSelector = By.cssSelector("div.form-group input[title='A password is required']");
    private By repeatPasswordSelector = By.cssSelector("div.form-group input[title='Repeated password is required']");

    private By createAnAccSelector = By.cssSelector("button.btn.btn-default.login-btn");

    public Register(WebDriver driver) {
        super(driver);
        this.firstName = new TextInput(driver, firstNameSelector);
        this.lastName = new TextInput(driver, lastNameSelector);
        this.country = new Select(driver, countrySelecotr);
        this.state = new TextInput(driver, stateSelector);
        this.emailAddress = new TextInput(driver, emailAddressSelector);
        this.password = new TextInput(driver, passwordSelector);
        this.repeatPassword = new TextInput(driver, repeatPasswordSelector);

    }

    private void insertFirstName(User user){
        this.firstName.fillingField(user.getFirstName());
    }
    private void insertLastName(User user){
        this.lastName.fillingField(user.getLastName());
    }
    private void insertCountry(Address address){
        this.country.chooseOption(address.getCountry());
    }
    private void insertState(Address address){
        this.state.fillingField(address.getState());
    }
    private void insertEmail(User user){
        this.emailAddress.fillingField(user.getEmail());
    }
    private void insertPassword(User user){
        this.password.fillingField(user.getPassword());
    }
    private void insertRepeatedPassword(User user){
        this.repeatPassword.fillingField(user.getPassword());
    }

    public void clickCreateAnAccButton(){
        this.createAnAccButton = new Button(driver, createAnAccSelector);
        createAnAccButton.click();
    }

    public void fillInRegistrationForm(User user, Address address){
        insertFirstName(user);
        insertLastName(user);
        insertCountry(address);
        insertState(address);
        insertEmail(user);
        insertPassword(user);
        insertRepeatedPassword(user);
    }

}
