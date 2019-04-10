package test.PurchasingProces;

import models.Address;
import models.Bag;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class RegisteredUser {
//    private WebDriver driver;
//    private MainPage mainPage;
//    private Address address;
//    private User user;
//    private Bag bag;
//
//    @Before
//    public void startBrowser() {
//        driver = new ChromeDriver();
////        mainPage = new MainPage(driver);
//        this.address = new Address();
//        this.user = new User();
//    }
//
//    @Before
//    public void register() {
//        mainPage = new MainPage(driver);
//        mainPage.enterRegistrationPage();
//        Register registerPage = new Register(driver);
//        registerPage.fillInRegistrationForm(user, address);
//        registerPage.clickCreateAnAccButton();
//        AfterRegistrationPage afterRegistrationPage = new AfterRegistrationPage(driver);
//        Assert.assertEquals(user.getFirstName(), afterRegistrationPage.getLoginFromNavBar());
//        afterRegistrationPage.clickLogoToGoToMainPage();
//    }
//
//    //    @After
////    public void close() {
////        mainPage.close();
////    }
//
//
//    @Test
//    public void registeredPurchaseOrderConfirmation() {
//        mainPage = new MainPage(driver);
//        mainPage.chooseHandbagsCategory();
//        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
//        handbagsCataloguePage.addBagToCart();
//        handbagsCataloguePage.proceedToCheckout();
//        ReviewYourOrderPage review = new ReviewYourOrderPage(driver);
//        review.orderToCheckout();
//        CheckoutPage checkoutPage = new CheckoutPage(driver);
//        checkoutPage.insertDataForRegisteredUser(user, address);
//        checkoutPage.submitOrder();
//        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
//        orderConfirmationPage.gotToMyAcc();
//
//
//    }
}
