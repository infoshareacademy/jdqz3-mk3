package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HandbagsCataloguePage;
import pages.MainPage;
import pages.ReviewYourOrderPage;

public class CartUpdating {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }
    @After
    public void close() {
        mainPage.close();
    }

    @Test
    public void deleteFromCart(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.clickDeleteFromCart();
        Assert.assertEquals("http://demo.shopizer.com:8080/shop/", driver.getCurrentUrl());
    }

    @Test
    public void deleteFromCartCataloguePage(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.clickDeleteButton();
        Assert.assertEquals("Shopping cart (0)", handbagsCataloguePage.readAmountInCart());
    }

    @Test
    public void changeAmount(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.changeQuantity("2");
        reviewYourOrderPage.recalculateClick();
        Assert.assertEquals("(2)", reviewYourOrderPage.readAmountInCart());
    }
}