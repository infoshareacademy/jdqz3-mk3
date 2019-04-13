package pages;

import elements.Button;
import elements.Label;
import elements.Select;
import elements.TextInput;
import models.Address;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By logInOrRegister = By.cssSelector("p.muted.common-row a");
    private By firstName = By.xpath("//input[@id='customer.firstName']");
    private By lastName = By.xpath("//input[@id='customer.lastName']");
    private By billingCompany = By.cssSelector("[name='customer.billing.company']");
    private By address = By.cssSelector("input[name='customer.billing.address']");
    private By city = By.cssSelector("[name='customer.billing.city']");
    private By country = By.cssSelector("[name='customer.billing.country']");
    private By stateProvince = By.cssSelector("[name='customer.billing.stateProvince']");
    private By postalCode = By.cssSelector("[name='customer.billing.postalCode']");
    private By emailAddress = By.cssSelector("[name='customer.emailAddress']");
    private By phoneNumber = By.cssSelector("[name='customer.billing.phone']");
    private By submitOrder = By.xpath("//button[@id='submitOrder']");
    private By createAnAccountCheckBoxSelecotr = By.cssSelector("div.checkout-form-list.create-acc input[type='checkbox");
    private By insertAPasswodSelector = By.cssSelector("div#cbox_info input.required");

    private Button logInOrRegisterButton;
    private TextInput firstNameText;
    private TextInput lastNameText;
    private TextInput billingCompanyText;
    private TextInput addressText;
    private TextInput cityText;
    private Select countrySelect;
    private TextInput stateProvinceText;
    private TextInput postalCodeText;
    private TextInput emailAddressText;
    private TextInput phoneNumberText;
    private Button submitOrderButton;
    private Button createAnAccountCheckbox;
    private TextInput insertAPassword;

    private Label firstNameLabel;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.firstNameText = new TextInput(driver, firstName);
        this.lastNameText = new TextInput(driver, lastName);
        this.billingCompanyText = new TextInput(driver, billingCompany);
        this.addressText = new TextInput(driver, address);
        this.cityText = new TextInput(driver, city);
        this.countrySelect = new Select(driver, country);
        this.stateProvinceText = new TextInput(driver, stateProvince);
        this.postalCodeText = new TextInput(driver, postalCode);
        this.emailAddressText = new TextInput(driver, emailAddress);
        this.phoneNumberText = new TextInput(driver, phoneNumber);

    }

    public void insertData(User user, Address address) {
        this.firstNameText.fillingField(user.getFirstName());
        this.lastNameText.fillingField(user.getLastName());
        this.billingCompanyText.fillingField(user.getBillingCompany());
        this.addressText.fillingField(address.getStreetAddress());
        this.cityText.fillingField(address.getCity());
        this.countrySelect.chooseOption(address.getCountry());
        this.stateProvinceText.fillingField(address.getState());
        this.postalCodeText.fillingField(address.getPostalCode());
        this.emailAddressText.fillingField(user.getEmail());
        this.phoneNumberText.fillingField(user.getPhoneNumber());
    }

    public void insertDataForLogedInUser(User user, Address address){
        this.billingCompanyText.fillingField(user.getBillingCompany());
        this.addressText.fillingField(address.getStreetAddress());
        this.cityText.fillingField(address.getCity());
        this.countrySelect.chooseOption(address.getCountry());
        this.stateProvinceText.fillingField(address.getState());
        this.postalCodeText.fillingField(address.getPostalCode());
        this.emailAddressText.fillingField(user.getEmail());
        this.phoneNumberText.fillingField(user.getPhoneNumber());
    }

    public void insertDataForRegisteredUser(User user, Address address) {
        this.billingCompanyText.fillingField(user.getBillingCompany());
        this.addressText.fillingField(address.getStreetAddress());
        this.cityText.fillingField(address.getCity());
        this.countrySelect.chooseOption(address.getCountry());
        this.stateProvinceText.fillingField(address.getState());
        this.postalCodeText.fillingField(address.getPostalCode());
        this.phoneNumberText.fillingField(user.getPhoneNumber());
    }


    public void submitOrder() {
        this.submitOrderButton = new Button(driver, submitOrder);
        this.submitOrderButton.clickWithJs();
    }

    public void logInOrRegisterButton() {
        this.logInOrRegisterButton = new Button(driver, logInOrRegister);
        this.logInOrRegisterButton.click();
    }

    public void checkCreateAnAccountCheckBox(User user) {
        this.createAnAccountCheckbox = new Button(driver, createAnAccountCheckBoxSelecotr);
        this.createAnAccountCheckbox.click();
        this.insertAPassword = new TextInput(driver, insertAPasswodSelector);
        insertAPassword.fillingField(user.getPassword());
    }

    private String getFirstName() {
        String nameAttribute = driver.findElement(By.xpath("//input[@id='customer.firstName']")).getAttribute("value");
        return nameAttribute;
    }

    private String getLastName() {
        String lastNameAttribute = driver.findElement(By.xpath("//input[@id='customer.lastName']")).getAttribute("value");
        return lastNameAttribute;
    }

    private String getStreetAddress() {
        String streetAddressAttribute =  driver.findElement(By.cssSelector("input[name='customer.billing.address']")).getAttribute("value");
        return streetAddressAttribute;
    }

    private String getCity(){
        String cityAttribute =  driver.findElement(By.cssSelector("[name='customer.billing.city']")).getAttribute("value");
        return cityAttribute;
    }
    private String getCountry(){
        String countryAttribute =  driver.findElement(By.cssSelector("[name='customer.billing.country']")).getAttribute("value");
        return countryAttribute;
    }
    private String getState(){
        String stateAttribute =  driver.findElement(By.cssSelector("[name='customer.billing.stateProvince']")).getAttribute("value");
        return stateAttribute;
    }
    private String getPostalCode(){
        String postalCodeAttribute =  driver.findElement(By.cssSelector("[name='customer.billing.postalCode']")).getAttribute("value");
        return postalCodeAttribute;
    }
    private String getEmail(){
        String emailAttribute =  driver.findElement(By.cssSelector("[name='customer.emailAddress']")).getAttribute("value");
        return emailAttribute;
    }
    private String getPhone(){
        String phoneAttribute =  driver.findElement(By.cssSelector("[name='customer.billing.phone']")).getAttribute("value");
        return phoneAttribute;
    }

    public String getUserData(){

        String UserData =
        getFirstName() + " " +
        getLastName() + " " +
        getStreetAddress() + " " +
        getCity() + " " +
        getCountry() + " " +
        getState() + " " +
        getPostalCode() + " " +
        getEmail() + " " +
        getPhone();

        return UserData;
    }


}