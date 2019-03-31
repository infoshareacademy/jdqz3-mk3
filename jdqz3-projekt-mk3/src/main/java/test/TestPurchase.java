package test;

import categories.CartTests;
import categories.PurchaseTests;
import models.Address;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class TestPurchase {
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

    @After
    public void close() {
        mainPage.close();
    }

    @Category(PurchaseTests.class)
    @Test
    public void purchaseBag() {
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

    @Category(CartTests.class)
    @Test
    public void addToCart() {
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage review = new ReviewYourOrderPage(driver);

        Assert.assertEquals("Chic vintage DeVille", review.isCartContentCorrect());
    }

    @Test
    public void priceInCart() {
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage review = new ReviewYourOrderPage(driver);

        Assert.assertEquals("$78.00", review.isPriceInCartCorect());
    }

    @Test
    public void register(){
        mainPage.enterRegistrationPage();
        Register registerPage = new Register(driver);
        registerPage.fillInRegistrationForm(user, address);
        registerPage.clickCreateAnAccButton();
    }

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
}