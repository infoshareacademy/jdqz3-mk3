package pages;

import elements.Button;
import elements.Label;
import elements.Select;
import elements.TextInput;
import models.Address;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingShippingPage extends BasePage {

    private Button billingAdressEdit;
    private By billingAdressEditSelector = By.xpath("//*[contains(text(),'Billing Address')]/a");

    private TextInput customerFirstName;
    private By customerFirstNameSelector = By.id("firstName");

    private TextInput customerLastName;
    private By customerLastNameSelector = By.id("lastName");

    private TextInput companyName;
    private By companyNameSelector = By.id("company");

    private TextInput customerStreetAddress;
    private By customerStreetAddressSelector = By.id("address");

    private TextInput customerCity;
    private By customerCitySelector = By.id("city");

    private Select customerCountry;
    private By customerCountrySelector = By.xpath("//select[@id='customer_country']");

    private TextInput customerStateProvince;
    private By customerStateProvinceSelector = By.id("hidden_zones");

    private TextInput postalCode;
    private By postalCodeSelector = By.id("billingPostalCode");

    private TextInput customerPhone;
    private By customerPhoneSelector = By.id("phone");

    private Button changeAddress;
    private By changeAddressSelector = By.xpath("//input[@id='submitAddress']");

    private Label confirmationMessage;
    private By confirmationMessageSelector = By.xpath("//div[@id='store.success']");

    private Label editedAddressMessage;
    private By editedAddressMessageSelector = By.xpath("//div[@id='store.success']");

    public BillingShippingPage(WebDriver driver){
        super(driver);
        this.customerFirstName = new TextInput(driver, customerFirstNameSelector);
        this.customerLastName = new TextInput(driver, customerLastNameSelector);
        this.customerStreetAddress= new TextInput(driver, customerStreetAddressSelector);
        this.customerCity = new TextInput(driver, customerCitySelector);
        this.customerCountry = new Select(driver, customerCountrySelector);
        this.customerStateProvince = new TextInput(driver, customerStateProvinceSelector);
        this.postalCode = new TextInput(driver, postalCodeSelector);
        this.customerPhone = new TextInput(driver, customerPhoneSelector);
    }

    public void insertCustomerFirstName(User user){
        this.customerFirstName.fillingField(user.getFirstName());
    }
    public void insertCustomerLastName(User user){
        this.customerLastName.fillingField(user.getLastName());
    }
    public void insertCustomerStreetAddress(Address address){
        this.customerStreetAddress.fillingField(address.getStreetAddress());
    }
    public void insertCustomerCity(Address address){
        this.customerCity.fillingField(address.getCity());
    }
    public void insertCustomerCountry(Address address){
        this.customerCountry.chooseOption(address.getCountry());
    }
    public void insertCustomerStateProvince(Address address){
        this.customerStateProvince.fillingField(address.getState());
    }
    public void insertPostalCode(Address address){
        this.postalCode.fillingField(address.getPostalCode());
    }
    public void insertCustomerPhone(User user){
        this.customerPhone.fillingField(user.getPhoneNumber());
    }
    public void clickChangeAddressButton(){
        this.changeAddress = new Button(driver, changeAddressSelector);
        changeAddress.click();
    }

    public void fillShippingAddress(User user, Address address) {
        insertCustomerFirstName(user);
        insertCustomerLastName(user);
        insertCustomerStreetAddress(address);
        insertCustomerCity(address);
        insertCustomerCountry(address);
        insertCustomerStateProvince(address);
        insertPostalCode(address);
        insertCustomerPhone(user);
        clickChangeAddressButton();
    }

    public String successMessage() {
        this.confirmationMessage = new Label(driver, confirmationMessageSelector);
        return this.confirmationMessage.readLabel();
    }

    public String readEditedAddressMessage() {
        this.editedAddressMessage = new Label(driver, editedAddressMessageSelector);
        return this.editedAddressMessage.readLabel();
    }
}