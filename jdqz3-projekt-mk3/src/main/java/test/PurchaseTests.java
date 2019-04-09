package test;

import categories.PurchaseCategory;
import models.Address;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class PurchaseTests {
    private WebDriver driver;
    private MainPage mainPage;
    private Address address;
    private User user;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.address = new Address();
        this.user = new User();
    }

//    @After
//    public void close() {
//        mainPage.close();
//    }

    @Category(PurchaseCategory.class)
    @Test
    public void purchaseBagWithNoRegistration() {
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage review = new ReviewYourOrderPage(driver);
        review.orderToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertData(user, address);
        checkoutPage.submitOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        Assert.assertEquals("Order completed", orderConfirmationPage.orderConfirmationLabel());
        Assert.assertTrue(orderConfirmationPage.orderConfirmationLabel().equals("Order completed"));
    }

//    @Category(UserCategory.class)
//    @Test
//    public void register(){
//        mainPage.enterRegistrationPage();
//        Register registerPage = new Register(driver);
//        registerPage.fillInRegistrationForm(user, address);
//        registerPage.clickCreateAnAccButton();
//    }

    @Category(PurchaseCategory.class)
    @Test
    public void purchaseWihRegistration(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage review = new ReviewYourOrderPage(driver);
        review.orderToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.logInOrRegisterButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.createNewAccount();
        mainPage.enterRegistrationPage();
        Register registerPage = new Register(driver);
        registerPage.fillInRegistrationForm(user, address);
        registerPage.clickCreateAnAccButton();
        AfterRegistrationPage afterRegistrationPage = new AfterRegistrationPage(driver);
        afterRegistrationPage.getShoppingCardAmound();
        Assert.assertEquals("Shopping cart (1)", afterRegistrationPage.getShoppingCardAmound());
    }

    @Test
    public void purchaseABigAmmount(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage review = new ReviewYourOrderPage(driver);
        review.changeQuantity("10000");
        review.recalculateClick();
        review.orderToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertData(user, address);
        checkoutPage.submitOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        Assert.assertEquals("Order completed", orderConfirmationPage.orderConfirmationLabel());
        Assert.assertTrue(orderConfirmationPage.orderConfirmationLabel().equals("Order completed"));
    }

    @Test
    public void purchaseAsRegisteredUser(){
        this.address = new Address();
        this.user = new User();
        mainPage.enterRegistrationPage();
        Register registerPage = new Register(driver);
        registerPage.fillInRegistrationForm(user, address);
        registerPage.clickCreateAnAccButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToBillingAndShippingInformation();
        accountPage.clickBillingAddresEditButton();
        BillingShippingPage billingShippingPage = new BillingShippingPage(driver);
        billingShippingPage.fillShippingAddress(user, address);
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.clickHandBagCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage review = new ReviewYourOrderPage(driver);
        review.orderToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(user.getFirstName(), checkoutPage.getFirstName());
//        Assert.assertEquals("Order completed", orderConfirmationPage.orderConfirmationLabel());
//        Assert.assertTrue(orderConfirmationPage.orderConfirmationLabel().equals("Order completed"));



    }


}
