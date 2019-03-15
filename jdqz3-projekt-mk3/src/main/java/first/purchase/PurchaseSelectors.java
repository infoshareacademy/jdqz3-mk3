package first.purchase;

public class PurchaseSelectors {
    private String beachBagsLink = "//div[contains(@class, 'mainmenu')]//a[text()='Beach bags']";
    private String retroStyleBag = "div#productsContainer div[item-name='Retro style bag'] div.store-btn-addtocart";
    private String shoppingCart = "div#miniCartSummary span";
    private String checkout = "li.checkout-bg a";
    private String proceedToCheckout = "//a[contains(text(), 'Proceed to checkout')]";
    private String firstName = "//input[@id='customer.firstName']";
    private String lastName = "//input[@id='customer.lastName']";
    private String billingCompany = "[name='customer.billing.company']";
    private String address = "input[name='customer.billing.address']";
    private String city = "[name='customer.billing.city']";
    private String country = "[name='customer.billing.country']";
    private String stateProvince = "[name='customer.billing.stateProvince']";
    private String postalCode = "[name='customer.billing.postalCode']";
    private String emailAddress = "[name='customer.emailAddress']";
    private String phoneNumber = "[name='customer.billing.phone']";
    private String submitOrder = "//button[@id='submitOrder']";

    public String getBeachBagsLink() {
        return beachBagsLink;
    }

    public String getRetroStyleBag() {
        return retroStyleBag;
    }

    public String getShoppingCart() {
        return shoppingCart;
    }

    public String getCheckout() {
        return checkout;
    }

    public String getProceedToCheckout() {
        return proceedToCheckout;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBillingCompany() {
        return billingCompany;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSubmitOrder() {
        return submitOrder;
    }
}