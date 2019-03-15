package first.purchase;

import org.openqa.selenium.By;

public class PurchaseSelectorsBy {
    private By beachBagsLink = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Beach bags']");
    private By retroStyleBag = By.cssSelector("div#productsContainer div[item-name='Retro style bag'] div.store-btn-addtocart");
    private By shoppingCart = By.cssSelector("div#miniCartSummary span");
    private By checkout = By.cssSelector("li.checkout-bg a");
    private By proceedToCheckout = By.xpath("//a[contains(text(), 'Proceed to checkout')]");
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

    public By getBeachBagsLink() {
        return beachBagsLink;
    }

    public By getRetroStyleBag() {
        return retroStyleBag;
    }

    public By getShoppingCart() {
        return shoppingCart;
    }

    public By getCheckout() {
        return checkout;
    }

    public By getProceedToCheckout() {
        return proceedToCheckout;
    }

    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getBillingCompany() {
        return billingCompany;
    }

    public By getAddress() {
        return address;
    }

    public By getCity() {
        return city;
    }

    public By getCountry() {
        return country;
    }

    public By getStateProvince() {
        return stateProvince;
    }

    public By getPostalCode() {
        return postalCode;
    }

    public By getEmailAddress() {
        return emailAddress;
    }

    public By getPhoneNumber() {
        return phoneNumber;
    }

    public By getSubmitOrder() {
        return submitOrder;
    }
}